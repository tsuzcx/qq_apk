package com.tencent.mm.sdk.storage.observer;

import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract interface IStorageObserver<T extends IAutoDBItem>
  extends IMvvmObserver<StorageObserverEvent<T>>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.observer.IStorageObserver
 * JD-Core Version:    0.7.0.1
 */