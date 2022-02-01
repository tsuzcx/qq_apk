package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.cjy;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public abstract interface ad
{
  public abstract boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5);
  
  public abstract void aC(Bundle paramBundle);
  
  public abstract void aD(Bundle paramBundle);
  
  public abstract boolean ffA();
  
  public abstract View ffB();
  
  public abstract boolean ffC();
  
  public abstract boolean ffD();
  
  public abstract boolean ffE();
  
  public abstract boolean k(int paramInt, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ad
 * JD-Core Version:    0.7.0.1
 */