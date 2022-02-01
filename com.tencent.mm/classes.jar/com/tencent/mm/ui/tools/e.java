package com.tencent.mm.ui.tools;

import android.view.View.OnFocusChangeListener;
import android.widget.TextView.OnEditorActionListener;
import java.util.ArrayList;

public abstract interface e
{
  public abstract void MV(boolean paramBoolean);
  
  public abstract void MW(boolean paramBoolean);
  
  public abstract String getSearchContent();
  
  public abstract void jCK();
  
  public abstract boolean jCL();
  
  public abstract boolean jCM();
  
  public abstract void setAutoMatchKeywords(boolean paramBoolean);
  
  public abstract void setBackClickCallback(ActionBarSearchView.a parama);
  
  public abstract void setCallBack(ActionBarSearchView.b paramb);
  
  public abstract void setEditTextEnabled(boolean paramBoolean);
  
  public abstract void setFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void setHint(CharSequence paramCharSequence);
  
  public abstract void setImeScene(int paramInt);
  
  public abstract void setKeywords(ArrayList<String> paramArrayList);
  
  public abstract void setNotRealCallBack(SearchViewNotRealTimeHelper.a parama);
  
  public abstract void setOnEditorActionListener(TextView.OnEditorActionListener paramOnEditorActionListener);
  
  public abstract void setSearchContent(String paramString);
  
  public abstract void setSearchTipIcon(int paramInt);
  
  public abstract void setSelectedTag(String paramString);
  
  public abstract void setStatusBtnEnabled(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.tools.e
 * JD-Core Version:    0.7.0.1
 */