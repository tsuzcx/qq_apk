package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderMediaReportObject
  extends com.tencent.mm.bw.a
{
  public int cdnControl;
  public int cdnUploadRetCode;
  public int cdnUploadTime;
  public apo codecInfo;
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
    AppMethodBeat.i(189370);
    this.multiMediaInfo = new LinkedList();
    AppMethodBeat.o(189370);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169008);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.remuxTime);
      paramVarArgs.aS(2, this.remuxRetCode);
      paramVarArgs.aS(3, this.cdnUploadTime);
      paramVarArgs.aS(4, this.cdnUploadRetCode);
      paramVarArgs.aS(5, this.zipTime);
      paramVarArgs.aS(6, this.zipRetCode);
      paramVarArgs.aS(7, this.mediaType);
      if (this.mediaId != null) {
        paramVarArgs.d(8, this.mediaId);
      }
      if (this.origin != null)
      {
        paramVarArgs.lJ(9, this.origin.computeSize());
        this.origin.writeFields(paramVarArgs);
      }
      if (this.target != null)
      {
        paramVarArgs.lJ(10, this.target.computeSize());
        this.target.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(11, this.isBigFile);
      paramVarArgs.aS(12, this.cdnControl);
      paramVarArgs.aS(13, this.videoFinalSize);
      paramVarArgs.e(14, 8, this.multiMediaInfo);
      if (this.codecInfo != null)
      {
        paramVarArgs.lJ(15, this.codecInfo.computeSize());
        this.codecInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.playDecoderType);
      AppMethodBeat.o(169008);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.remuxTime) + 0 + f.a.a.b.b.a.bz(2, this.remuxRetCode) + f.a.a.b.b.a.bz(3, this.cdnUploadTime) + f.a.a.b.b.a.bz(4, this.cdnUploadRetCode) + f.a.a.b.b.a.bz(5, this.zipTime) + f.a.a.b.b.a.bz(6, this.zipRetCode) + f.a.a.b.b.a.bz(7, this.mediaType);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.mediaId);
      }
      i = paramInt;
      if (this.origin != null) {
        i = paramInt + f.a.a.a.lI(9, this.origin.computeSize());
      }
      paramInt = i;
      if (this.target != null) {
        paramInt = i + f.a.a.a.lI(10, this.target.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.isBigFile) + f.a.a.b.b.a.bz(12, this.cdnControl) + f.a.a.b.b.a.bz(13, this.videoFinalSize) + f.a.a.a.c(14, 8, this.multiMediaInfo);
      paramInt = i;
      if (this.codecInfo != null) {
        paramInt = i + f.a.a.a.lI(15, this.codecInfo.computeSize());
      }
      i = f.a.a.b.b.a.bz(16, this.playDecoderType);
      AppMethodBeat.o(169008);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.multiMediaInfo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(169008);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      FinderMediaReportObject localFinderMediaReportObject = (FinderMediaReportObject)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169008);
        return -1;
      case 1: 
        localFinderMediaReportObject.remuxTime = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169008);
        return 0;
      case 2: 
        localFinderMediaReportObject.remuxRetCode = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169008);
        return 0;
      case 3: 
        localFinderMediaReportObject.cdnUploadTime = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169008);
        return 0;
      case 4: 
        localFinderMediaReportObject.cdnUploadRetCode = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169008);
        return 0;
      case 5: 
        localFinderMediaReportObject.zipTime = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169008);
        return 0;
      case 6: 
        localFinderMediaReportObject.zipRetCode = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169008);
        return 0;
      case 7: 
        localFinderMediaReportObject.mediaType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169008);
        return 0;
      case 8: 
        localFinderMediaReportObject.mediaId = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169008);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderMediaReportObject.origin = ((FinderMediaReportInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderMediaReportObject.target = ((FinderMediaReportInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      case 11: 
        localFinderMediaReportObject.isBigFile = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169008);
        return 0;
      case 12: 
        localFinderMediaReportObject.cdnControl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169008);
        return 0;
      case 13: 
        localFinderMediaReportObject.videoFinalSize = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169008);
        return 0;
      case 14: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportInfo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportInfo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderMediaReportObject.multiMediaInfo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localFinderMediaReportObject.codecInfo = ((apo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      }
      localFinderMediaReportObject.playDecoderType = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(169008);
      return 0;
    }
    AppMethodBeat.o(169008);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMediaReportObject
 * JD-Core Version:    0.7.0.1
 */