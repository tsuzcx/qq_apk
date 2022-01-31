package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.model.gdpr.a;
import com.tencent.mm.model.gdpr.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.n.a;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ac
{
  private static String[] rfA;
  private static boolean rfB = false;
  
  private static LinkedList<bna> U(ArrayList<byte[]> paramArrayList)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localLinkedList;
    }
    int i = 0;
    while (i < paramArrayList.size()) {
      try
      {
        azs localazs = new azs();
        localazs.aH((byte[])paramArrayList.get(i));
        bna localbna = new bna();
        localbna.tGf = localazs.tvP;
        localbna.kRN = localazs.desc;
        localbna.sEi = localazs.scope;
        localbna.gkl = localazs.gkl;
        localLinkedList.add(localbna);
        i += 1;
      }
      catch (IOException paramArrayList)
      {
        y.w("MicroMsg.OauthAuthorizeLogic", "bytesListToBytesListScopeInfoList: i:%d, exp:%s", new Object[] { Integer.valueOf(i), paramArrayList.getLocalizedMessage() });
        localLinkedList.clear();
        return localLinkedList;
      }
    }
    return localLinkedList;
  }
  
  private static ArrayList<byte[]> at(LinkedList<azs> paramLinkedList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramLinkedList == null) || (paramLinkedList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramLinkedList.size()) {
      try
      {
        localArrayList.add(((azs)paramLinkedList.get(i)).toByteArray());
        i += 1;
      }
      catch (IOException paramLinkedList)
      {
        y.w("MicroMsg.OauthAuthorizeLogic", "oauthScopeInfoListToBytesList index:%d, exp:%s ", new Object[] { Integer.valueOf(i), paramLinkedList.getLocalizedMessage() });
        localArrayList.clear();
        return localArrayList;
      }
    }
    return localArrayList;
  }
  
  public static abstract interface b
  {
    public abstract void add(int paramInt);
    
    public abstract boolean cbR();
    
    public abstract void remove(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.ac
 * JD-Core Version:    0.7.0.1
 */