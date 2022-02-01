package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderMediaReportObject
  extends com.tencent.mm.bx.a
{
  public int cdnControl;
  public int cdnUploadRetCode;
  public int cdnUploadTime;
  public boy codecInfo;
  public int isBigFile;
  public String mediaId;
  public int mediaType;
  public LinkedList<FinderMediaReportInfo> multiMediaInfo;
  public FinderMediaReportInfo origin;
  public int playDecoderType;
  public int remuxRetCode;
  public int remuxTime;
  public FinderMediaReportInfo target;
  public int videoFinalSize;
  public int zipRetCode;
  public int zipTime;
  
  public FinderMediaReportObject()
  {
    AppMethodBeat.i(258167);
    this.multiMediaInfo = new LinkedList();
    AppMethodBeat.o(258167);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169008);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.remuxTime);
      paramVarArgs.bS(2, this.remuxRetCode);
      paramVarArgs.bS(3, this.cdnUploadTime);
      paramVarArgs.bS(4, this.cdnUploadRetCode);
      paramVarArgs.bS(5, this.zipTime);
      paramVarArgs.bS(6, this.zipRetCode);
      paramVarArgs.bS(7, this.mediaType);
      if (this.mediaId != null) {
        paramVarArgs.g(8, this.mediaId);
      }
      if (this.origin != null)
      {
        paramVarArgs.qD(9, this.origin.computeSize());
        this.origin.writeFields(paramVarArgs);
      }
      if (this.target != null)
      {
        paramVarArgs.qD(10, this.target.computeSize());
        this.target.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.isBigFile);
      paramVarArgs.bS(12, this.cdnControl);
      paramVarArgs.bS(13, this.videoFinalSize);
      paramVarArgs.e(14, 8, this.multiMediaInfo);
      if (this.codecInfo != null)
      {
        paramVarArgs.qD(15, this.codecInfo.computeSize());
        this.codecInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(16, this.playDecoderType);
      AppMethodBeat.o(169008);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.remuxTime) + 0 + i.a.a.b.b.a.cJ(2, this.remuxRetCode) + i.a.a.b.b.a.cJ(3, this.cdnUploadTime) + i.a.a.b.b.a.cJ(4, this.cdnUploadRetCode) + i.a.a.b.b.a.cJ(5, this.zipTime) + i.a.a.b.b.a.cJ(6, this.zipRetCode) + i.a.a.b.b.a.cJ(7, this.mediaType);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.mediaId);
      }
      i = paramInt;
      if (this.origin != null) {
        i = paramInt + i.a.a.a.qC(9, this.origin.computeSize());
      }
      paramInt = i;
      if (this.target != null) {
        paramInt = i + i.a.a.a.qC(10, this.target.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.isBigFile) + i.a.a.b.b.a.cJ(12, this.cdnControl) + i.a.a.b.b.a.cJ(13, this.videoFinalSize) + i.a.a.a.c(14, 8, this.multiMediaInfo);
      paramInt = i;
      if (this.codecInfo != null) {
        paramInt = i + i.a.a.a.qC(15, this.codecInfo.computeSize());
      }
      i = i.a.a.b.b.a.cJ(16, this.playDecoderType);
      AppMethodBeat.o(169008);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.multiMediaInfo.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169008);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      FinderMediaReportObject localFinderMediaReportObject = (FinderMediaReportObject)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169008);
        return -1;
      case 1: 
        localFinderMediaReportObject.remuxTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169008);
        return 0;
      case 2: 
        localFinderMediaReportObject.remuxRetCode = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169008);
        return 0;
      case 3: 
        localFinderMediaReportObject.cdnUploadTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169008);
        return 0;
      case 4: 
        localFinderMediaReportObject.cdnUploadRetCode = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169008);
        return 0;
      case 5: 
        localFinderMediaReportObject.zipTime = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169008);
        return 0;
      case 6: 
        localFinderMediaReportObject.zipRetCode = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169008);
        return 0;
      case 7: 
        localFinderMediaReportObject.mediaType = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169008);
        return 0;
      case 8: 
        localFinderMediaReportObject.mediaId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169008);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderMediaReportInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderMediaReportInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderMediaReportObject.origin = ((FinderMediaReportInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderMediaReportInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderMediaReportInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderMediaReportObject.target = ((FinderMediaReportInfo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      case 11: 
        localFinderMediaReportObject.isBigFile = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169008);
        return 0;
      case 12: 
        localFinderMediaReportObject.cdnControl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169008);
        return 0;
      case 13: 
        localFinderMediaReportObject.videoFinalSize = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(169008);
        return 0;
      case 14: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderMediaReportInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderMediaReportInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderMediaReportObject.multiMediaInfo.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      case 15: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new boy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((boy)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderMediaReportObject.codecInfo = ((boy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      }
      localFinderMediaReportObject.playDecoderType = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(169008);
      return 0;
    }
    AppMethodBeat.o(169008);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMediaReportObject
 * JD-Core Version:    0.7.0.1
 */