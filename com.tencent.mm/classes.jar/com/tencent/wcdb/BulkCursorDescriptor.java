package com.tencent.wcdb;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class BulkCursorDescriptor
  implements Parcelable
{
  public static final Parcelable.Creator<BulkCursorDescriptor> CREATOR;
  public String[] columnNames;
  public int count;
  public IBulkCursor cursor;
  public boolean wantsAllOnMoveCalls;
  public CursorWindow window;
  
  static
  {
    AppMethodBeat.i(2647);
    CREATOR = new Parcelable.Creator()
    {
      public final BulkCursorDescriptor createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(2641);
        BulkCursorDescriptor localBulkCursorDescriptor = new BulkCursorDescriptor();
        localBulkCursorDescriptor.readFromParcel(paramAnonymousParcel);
        AppMethodBeat.o(2641);
        return localBulkCursorDescriptor;
      }
      
      public final BulkCursorDescriptor[] newArray(int paramAnonymousInt)
      {
        return new BulkCursorDescriptor[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(2647);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(2646);
    this.cursor = BulkCursorNative.asInterface(paramParcel.readStrongBinder());
    this.columnNames = readStringArray(paramParcel);
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.wantsAllOnMoveCalls = bool;
      this.count = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {
        this.window = ((CursorWindow)CursorWindow.CREATOR.createFromParcel(paramParcel));
      }
      AppMethodBeat.o(2646);
      return;
    }
  }
  
  public final String[] readStringArray(Parcel paramParcel)
  {
    AppMethodBeat.i(2645);
    Object localObject = null;
    int j = paramParcel.readInt();
    if (j >= 0)
    {
      String[] arrayOfString = new String[j];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfString;
        if (i >= j) {
          break;
        }
        arrayOfString[i] = paramParcel.readString();
        i += 1;
      }
    }
    AppMethodBeat.o(2645);
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(2644);
    paramParcel.writeStrongBinder(this.cursor.asBinder());
    paramParcel.writeStringArray(this.columnNames);
    if (this.wantsAllOnMoveCalls) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.count);
      if (this.window == null) {
        break;
      }
      paramParcel.writeInt(1);
      this.window.writeToParcel(paramParcel, paramInt);
      AppMethodBeat.o(2644);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(2644);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorDescriptor
 * JD-Core Version:    0.7.0.1
 */