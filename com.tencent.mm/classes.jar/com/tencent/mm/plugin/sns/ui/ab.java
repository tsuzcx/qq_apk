package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmn;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public abstract interface ab
{
  public abstract boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, bmn parambmn, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5);
  
  public abstract void af(Bundle paramBundle);
  
  public abstract void ag(Bundle paramBundle);
  
  public abstract boolean dyU();
  
  public abstract View dyV();
  
  public abstract boolean dyW();
  
  public abstract boolean j(int paramInt, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ab
 * JD-Core Version:    0.7.0.1
 */