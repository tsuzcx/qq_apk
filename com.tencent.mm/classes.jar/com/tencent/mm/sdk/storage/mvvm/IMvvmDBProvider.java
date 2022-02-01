package com.tencent.mm.sdk.storage.mvvm;

import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/mvvm/IMvvmDBProvider;", "", "getDB", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface IMvvmDBProvider
{
  public abstract ISQLiteDatabase getDB();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.mvvm.IMvvmDBProvider
 * JD-Core Version:    0.7.0.1
 */