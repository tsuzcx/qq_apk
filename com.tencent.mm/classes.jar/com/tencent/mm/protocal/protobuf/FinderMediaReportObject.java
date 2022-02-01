package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderMediaReportObject
  extends com.tencent.mm.bw.a
{
  public int cdnControl;
  public int cdnUploadRetCode;
  public int cdnUploadTime;
  public ayg codecInfo;
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
    AppMethodBeat.i(209587);
    this.multiMediaInfo = new LinkedList();
    AppMethodBeat.o(209587);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169008);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.remuxTime);
      paramVarArgs.aM(2, this.remuxRetCode);
      paramVarArgs.aM(3, this.cdnUploadTime);
      paramVarArgs.aM(4, this.cdnUploadRetCode);
      paramVarArgs.aM(5, this.zipTime);
      paramVarArgs.aM(6, this.zipRetCode);
      paramVarArgs.aM(7, this.mediaType);
      if (this.mediaId != null) {
        paramVarArgs.e(8, this.mediaId);
      }
      if (this.origin != null)
      {
        paramVarArgs.ni(9, this.origin.computeSize());
        this.origin.writeFields(paramVarArgs);
      }
      if (this.target != null)
      {
        paramVarArgs.ni(10, this.target.computeSize());
        this.target.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.isBigFile);
      paramVarArgs.aM(12, this.cdnControl);
      paramVarArgs.aM(13, this.videoFinalSize);
      paramVarArgs.e(14, 8, this.multiMediaInfo);
      if (this.codecInfo != null)
      {
        paramVarArgs.ni(15, this.codecInfo.computeSize());
        this.codecInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(16, this.playDecoderType);
      AppMethodBeat.o(169008);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.remuxTime) + 0 + g.a.a.b.b.a.bu(2, this.remuxRetCode) + g.a.a.b.b.a.bu(3, this.cdnUploadTime) + g.a.a.b.b.a.bu(4, this.cdnUploadRetCode) + g.a.a.b.b.a.bu(5, this.zipTime) + g.a.a.b.b.a.bu(6, this.zipRetCode) + g.a.a.b.b.a.bu(7, this.mediaType);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.mediaId);
      }
      i = paramInt;
      if (this.origin != null) {
        i = paramInt + g.a.a.a.nh(9, this.origin.computeSize());
      }
      paramInt = i;
      if (this.target != null) {
        paramInt = i + g.a.a.a.nh(10, this.target.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.isBigFile) + g.a.a.b.b.a.bu(12, this.cdnControl) + g.a.a.b.b.a.bu(13, this.videoFinalSize) + g.a.a.a.c(14, 8, this.multiMediaInfo);
      paramInt = i;
      if (this.codecInfo != null) {
        paramInt = i + g.a.a.a.nh(15, this.codecInfo.computeSize());
      }
      i = g.a.a.b.b.a.bu(16, this.playDecoderType);
      AppMethodBeat.o(169008);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.multiMediaInfo.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169008);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
        localFinderMediaReportObject.remuxTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169008);
        return 0;
      case 2: 
        localFinderMediaReportObject.remuxRetCode = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169008);
        return 0;
      case 3: 
        localFinderMediaReportObject.cdnUploadTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169008);
        return 0;
      case 4: 
        localFinderMediaReportObject.cdnUploadRetCode = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169008);
        return 0;
      case 5: 
        localFinderMediaReportObject.zipTime = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169008);
        return 0;
      case 6: 
        localFinderMediaReportObject.zipRetCode = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169008);
        return 0;
      case 7: 
        localFinderMediaReportObject.mediaType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169008);
        return 0;
      case 8: 
        localFinderMediaReportObject.mediaId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169008);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportInfo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderMediaReportObject.origin = ((FinderMediaReportInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      case 10: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportInfo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderMediaReportObject.target = ((FinderMediaReportInfo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      case 11: 
        localFinderMediaReportObject.isBigFile = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169008);
        return 0;
      case 12: 
        localFinderMediaReportObject.cdnControl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169008);
        return 0;
      case 13: 
        localFinderMediaReportObject.videoFinalSize = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169008);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderMediaReportInfo();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderMediaReportInfo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderMediaReportObject.multiMediaInfo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ayg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ayg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localFinderMediaReportObject.codecInfo = ((ayg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      }
      localFinderMediaReportObject.playDecoderType = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(169008);
      return 0;
    }
    AppMethodBeat.o(169008);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMediaReportObject
 * JD-Core Version:    0.7.0.1
 */