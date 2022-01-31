package com.tencent.tmassistantsdk.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.downloadservice.taskmanager.ServiceDownloadTask;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;
import com.tencent.tmassistantsdk.storage.table.DownloadInfoTable;
import java.util.ArrayList;

public class DBManager
{
  protected static DBManager mInstance = null;
  
  public static DBManager getInstance()
  {
    try
    {
      AppMethodBeat.i(76160);
      if (mInstance == null) {
        mInstance = new DBManager();
      }
      DBManager localDBManager = mInstance;
      AppMethodBeat.o(76160);
      return localDBManager;
    }
    finally {}
  }
  
  public void addDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(76163);
    DownloadInfoTable.add(paramDownloadInfo);
    AppMethodBeat.o(76163);
  }
  
  public void deleteDownloadInfo(String paramString)
  {
    AppMethodBeat.i(76164);
    DownloadInfoTable.del(paramString);
    ClientInfoTable.deleteItemsByURL(paramString);
    AppMethodBeat.o(76164);
  }
  
  public DownloadInfo queryDownloadInfoByUrl(String paramString)
  {
    AppMethodBeat.i(76165);
    paramString = DownloadInfoTable.query(paramString);
    AppMethodBeat.o(76165);
    return paramString;
  }
  
  public ArrayList<DownloadInfo> queryDownloadInfoList()
  {
    AppMethodBeat.i(76161);
    ArrayList localArrayList = DownloadInfoTable.load();
    AppMethodBeat.o(76161);
    return localArrayList;
  }
  
  public ArrayList<ServiceDownloadTask> queryWaitingAndDownloadingTaskList()
  {
    AppMethodBeat.i(76166);
    ArrayList localArrayList = DownloadInfoTable.query();
    AppMethodBeat.o(76166);
    return localArrayList;
  }
  
  public void saveClientInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(76167);
    ClientInfoTable.save(paramString1, paramString2);
    AppMethodBeat.o(76167);
  }
  
  public void saveDownloadInfoList(ArrayList<DownloadInfo> paramArrayList)
  {
    AppMethodBeat.i(76162);
    DownloadInfoTable.save(paramArrayList);
    AppMethodBeat.o(76162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.DBManager
 * JD-Core Version:    0.7.0.1
 */