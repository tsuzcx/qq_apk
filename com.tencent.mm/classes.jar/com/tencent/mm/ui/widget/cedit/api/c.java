package com.tencent.mm.ui.widget.cedit.api;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.ActionMode.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.ui.widget.MMEditText.a;
import com.tencent.mm.ui.widget.MMEditText.d;
import com.tencent.mm.ui.widget.edittext.a.e;
import java.util.List;

public abstract interface c
{
  public abstract void CS(boolean paramBoolean);
  
  public abstract void a(a parama);
  
  public abstract void a(List<String> paramList1, List<String> paramList2, String paramString, a.e parame);
  
  public abstract void addOnLayoutChangeListener(View.OnLayoutChangeListener paramOnLayoutChangeListener);
  
  public abstract void addTextChangedListener(TextWatcher paramTextWatcher);
  
  public abstract void append(CharSequence paramCharSequence);
  
  public abstract void bol(String paramString);
  
  public abstract void clearComposingText();
  
  public abstract void clearFocus();
  
  public abstract void destroy();
  
  public abstract void gYF();
  
  public abstract View gYG();
  
  public abstract boolean gYH();
  
  public abstract ViewParent gYI();
  
  public abstract boolean gYJ();
  
  public abstract Context gYK();
  
  public abstract int gYL();
  
  public abstract CharSequence getContentDescription();
  
  public abstract CharSequence getHint();
  
  public abstract int getImeOptions();
  
  public abstract InputConnection getInputConnection();
  
  public abstract Bundle getInputExtras(boolean paramBoolean);
  
  public abstract int getInputType();
  
  public abstract int getLineCount();
  
  public abstract TextPaint getPaint();
  
  public abstract CharSequence getPasterContent();
  
  public abstract int getPasterLen();
  
  public abstract int getSelectionStart();
  
  public abstract Editable getText();
  
  public abstract float getTextSize();
  
  public abstract int getVisibility();
  
  public abstract int length();
  
  public abstract void onPause();
  
  public abstract void refresh(boolean paramBoolean);
  
  public abstract void removeOnLayoutChangeListener(View.OnLayoutChangeListener paramOnLayoutChangeListener);
  
  public abstract void removeTextChangedListener(TextWatcher paramTextWatcher);
  
  public abstract void setAlpha(float paramFloat);
  
  public abstract void setBackListener(MMEditText.a parama);
  
  public abstract void setBreakStrategy(int paramInt);
  
  public abstract void setContentDescription(CharSequence paramCharSequence);
  
  public abstract void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback);
  
  public abstract void setEnableSendBtn(boolean paramBoolean);
  
  public abstract void setFilters(InputFilter[] paramArrayOfInputFilter);
  
  public abstract void setHint(CharSequence paramCharSequence);
  
  public abstract void setImeOptions(int paramInt);
  
  public abstract void setInputType(int paramInt);
  
  public abstract void setKeyCodeEnterListener(MMEditText.d paramd);
  
  public abstract void setMaxHeight(int paramInt);
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setOnDragListener(View.OnDragListener paramOnDragListener);
  
  public abstract void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener);
  
  public abstract void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener);
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void setPasterLen(int paramInt);
  
  public abstract void setSelection(int paramInt);
  
  public abstract void setText(CharSequence paramCharSequence);
  
  public abstract void setTextColor(int paramInt);
  
  public abstract void setTextSize(int paramInt, float paramFloat);
  
  public abstract void setVisibility(int paramInt);
  
  public static abstract interface a
  {
    public abstract boolean ZY(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.cedit.api.c
 * JD-Core Version:    0.7.0.1
 */