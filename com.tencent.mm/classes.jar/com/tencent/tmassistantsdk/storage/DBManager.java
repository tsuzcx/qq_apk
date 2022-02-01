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
      AppMethodBeat.i(102406);
      if (mInstance == null) {
        mInstance = new DBManager();
      }
      DBManager localDBManager = mInstance;
      AppMethodBeat.o(102406);
      return localDBManager;
    }
    finally {}
  }
  
  public void addDownloadInfo(DownloadInfo paramDownloadInfo)
  {
    AppMethodBeat.i(102409);
    DownloadInfoTable.add(paramDownloadInfo);
    AppMethodBeat.o(102409);
  }
  
  public void deleteDownloadInfo(String paramString)
  {
    AppMethodBeat.i(102410);
    DownloadInfoTable.del(paramString);
    ClientInfoTable.deleteItemsByURL(paramString);
    AppMethodBeat.o(102410);
  }
  
  public DownloadInfo queryDownloadInfoByUrl(String paramString)
  {
    AppMethodBeat.i(102411);
    paramString = DownloadInfoTable.query(paramString);
    AppMethodBeat.o(102411);
    return paramString;
  }
  
  public ArrayList<DownloadInfo> queryDownloadInfoList()
  {
    AppMethodBeat.i(102407);
    ArrayList localArrayList = DownloadInfoTable.load();
    AppMethodBeat.o(102407);
    return localArrayList;
  }
  
  public ArrayList<ServiceDownloadTask> queryWaitingAndDownloadingTaskList()
  {
    AppMethodBeat.i(102412);
    ArrayList localArrayList = DownloadInfoTable.query();
    AppMethodBeat.o(102412);
    return localArrayList;
  }
  
  public void saveClientInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102413);
    ClientInfoTable.save(paramString1, paramString2);
    AppMethodBeat.o(102413);
  }
  
  public void saveDownloadInfoList(ArrayList<DownloadInfo> paramArrayList)
  {
    AppMethodBeat.i(102408);
    DownloadInfoTable.save(paramArrayList);
    AppMethodBeat.o(102408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tmassistantsdk.storage.DBManager
 * JD-Core Version:    0.7.0.1
 */