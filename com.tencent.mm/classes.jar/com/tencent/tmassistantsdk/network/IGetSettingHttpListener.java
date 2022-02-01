package com.tencent.tmassistantsdk.network;

import com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;

public abstract interface IGetSettingHttpListener
{
  public abstract void onSettingHttpRequestFinish(GetSettingsRequest paramGetSettingsRequest, GetSettingsResponse paramGetSettingsResponse, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tmassistantsdk.network.IGetSettingHttpListener
 * JD-Core Version:    0.7.0.1
 */