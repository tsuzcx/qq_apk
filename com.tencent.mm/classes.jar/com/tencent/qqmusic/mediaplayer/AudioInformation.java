package com.tencent.qqmusic.mediaplayer;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AudioInformation
  implements Parcelable
{
  public static final int CBR = 1;
  public static final int CORRECT = 1;
  public static final Parcelable.Creator<AudioInformation> CREATOR;
  public static final int INCORRECT = 2;
  public static final int VBR_VBRI = 3;
  public static final int VBR_XING = 2;
  private int bitDept;
  private int bitrate;
  private int channels;
  private long duration;
  private int durationIsCorrect;
  private int isCbr;
  private int mAudioTypeValue;
  private long mPlaySample;
  private long sampleRate;
  
  static
  {
    AppMethodBeat.i(105570);
    CREATOR = new AudioInformation.1();
    AppMethodBeat.o(105570);
  }
  
  public AudioInformation()
  {
    this.duration = 0L;
    this.bitDept = 0;
    this.mPlaySample = 0L;
    this.isCbr = 0;
    this.durationIsCorrect = 2;
  }
  
  public AudioInformation(Parcel paramParcel)
  {
    AppMethodBeat.i(105564);
    this.duration = 0L;
    this.bitDept = 0;
    this.mPlaySample = 0L;
    this.isCbr = 0;
    this.durationIsCorrect = 2;
    readFromParcel(paramParcel);
    AppMethodBeat.o(105564);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean durationIsCorrect()
  {
    return this.durationIsCorrect == 1;
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    AppMethodBeat.i(105565);
    AudioFormat.AudioType localAudioType = AudioFormat.getAudioType(this.mAudioTypeValue);
    AppMethodBeat.o(105565);
    return localAudioType;
  }
  
  public int getBitDept()
  {
    return this.bitDept;
  }
  
  public int getBitrate()
  {
    return this.bitrate;
  }
  
  public int getChannels()
  {
    return this.channels;
  }
  
  public long getDuration()
  {
    return this.duration;
  }
  
  public long getPlaySample()
  {
    if (this.mPlaySample == 0L) {
      this.mPlaySample = this.sampleRate;
    }
    return this.mPlaySample;
  }
  
  public long getSampleRate()
  {
    return this.sampleRate;
  }
  
  public int getVbrType()
  {
    return this.isCbr;
  }
  
  public boolean isCbr()
  {
    return this.isCbr == 1;
  }
  
  public boolean isVbr()
  {
    return (this.isCbr == 2) || (this.isCbr == 3);
  }
  
  public void readFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(105568);
    this.sampleRate = paramParcel.readLong();
    this.channels = paramParcel.readInt();
    this.duration = paramParcel.readLong();
    this.bitrate = paramParcel.readInt();
    this.bitDept = paramParcel.readInt();
    this.mAudioTypeValue = paramParcel.readInt();
    this.mPlaySample = paramParcel.readLong();
    this.isCbr = paramParcel.readInt();
    this.durationIsCorrect = paramParcel.readInt();
    AppMethodBeat.o(105568);
  }
  
  public void setAudioType(AudioFormat.AudioType paramAudioType)
  {
    AppMethodBeat.i(105566);
    this.mAudioTypeValue = paramAudioType.getValue();
    AppMethodBeat.o(105566);
  }
  
  public void setBitDept(int paramInt)
  {
    this.bitDept = paramInt;
    if (paramInt >= 3) {
      this.bitDept = 3;
    }
  }
  
  public void setBitrate(int paramInt)
  {
    this.bitrate = paramInt;
  }
  
  public void setCbr(int paramInt)
  {
    this.isCbr = paramInt;
  }
  
  public void setChannels(int paramInt)
  {
    this.channels = paramInt;
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setPlaySample(long paramLong)
  {
    this.mPlaySample = paramLong;
  }
  
  public void setSampleRate(long paramLong)
  {
    this.sampleRate = paramLong;
  }
  
  public String toString()
  {
    AppMethodBeat.i(105569);
    String str = "[ sampleRate = " + this.sampleRate + ",channels = " + this.channels + ",bitrate = " + this.bitrate + ",bitDept = " + this.bitDept + ",isCbr = " + this.isCbr + ",durationIsCorrect = " + this.durationIsCorrect + ",duration = " + this.duration + "]";
    AppMethodBeat.o(105569);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105567);
    paramParcel.writeLong(this.sampleRate);
    paramParcel.writeInt(this.channels);
    paramParcel.writeLong(this.duration);
    paramParcel.writeInt(this.bitrate);
    paramParcel.writeInt(this.bitDept);
    paramParcel.writeInt(this.mAudioTypeValue);
    paramParcel.writeLong(this.mPlaySample);
    paramParcel.writeInt(this.isCbr);
    paramParcel.writeInt(this.durationIsCorrect);
    AppMethodBeat.o(105567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioInformation
 * JD-Core Version:    0.7.0.1
 */