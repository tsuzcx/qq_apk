package com.tencent.tmassistantsdk.network;

import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;

public abstract interface IGetAuthorizedHttpRequestListenner
{
  public abstract void onGetAuthorizedRequestFinished(AuthorizedResult paramAuthorizedResult, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.IGetAuthorizedHttpRequestListenner
 * JD-Core Version:    0.7.0.1
 */