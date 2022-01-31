package com.tencent.wcdb;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class BulkCursorDescriptor$1
  implements Parcelable.Creator<BulkCursorDescriptor>
{
  public final BulkCursorDescriptor createFromParcel(Parcel paramParcel)
  {
    BulkCursorDescriptor localBulkCursorDescriptor = new BulkCursorDescriptor();
    localBulkCursorDescriptor.readFromParcel(paramParcel);
    return localBulkCursorDescriptor;
  }
  
  public final BulkCursorDescriptor[] newArray(int paramInt)
  {
    return new BulkCursorDescriptor[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.wcdb.BulkCursorDescriptor.1
 * JD-Core Version:    0.7.0.1
 */