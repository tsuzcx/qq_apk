package android.support.v4.view;

import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;

class g
{
  public void b(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2)
  {
    paramLayoutInflater.setFactory2(paramFactory2);
    LayoutInflater.Factory localFactory = paramLayoutInflater.getFactory();
    if ((localFactory instanceof LayoutInflater.Factory2))
    {
      e.a(paramLayoutInflater, (LayoutInflater.Factory2)localFactory);
      return;
    }
    e.a(paramLayoutInflater, paramFactory2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.view.g
 * JD-Core Version:    0.7.0.1
 */