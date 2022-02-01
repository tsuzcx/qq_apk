package com.tencent.tmassistantsdk.downloadclient;

import com.tencent.tmassistantsdk.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;

public abstract interface ITMAssistantExchangeURLListenner
{
  public abstract void onExchangedURLSucceed(ArrayList<AppSimpleDetail> paramArrayList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.ITMAssistantExchangeURLListenner
 * JD-Core Version:    0.7.0.1
 */