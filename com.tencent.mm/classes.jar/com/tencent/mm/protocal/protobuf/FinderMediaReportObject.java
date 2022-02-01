package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderMediaReportObject
  extends com.tencent.mm.cd.a
{
  public int cdnControl;
  public int cdnUploadRetCode;
  public int cdnUploadTime;
  public bea codecInfo;
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
    AppMethodBeat.i(204319);
    this.multiMediaInfo = new LinkedList();
    AppMethodBeat.o(204319);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169008);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.remuxTime);
      paramVarArgs.aY(2, this.remuxRetCode);
      paramVarArgs.aY(3, this.cdnUploadTime);
      paramVarArgs.aY(4, this.cdnUploadRetCode);
      paramVarArgs.aY(5, this.zipTime);
      paramVarArgs.aY(6, this.zipRetCode);
      paramVarArgs.aY(7, this.mediaType);
      if (this.mediaId != null) {
        paramVarArgs.f(8, this.mediaId);
      }
      if (this.origin != null)
      {
        paramVarArgs.oE(9, this.origin.computeSize());
        this.origin.writeFields(paramVarArgs);
      }
      if (this.target != null)
      {
        paramVarArgs.oE(10, this.target.computeSize());
        this.target.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.isBigFile);
      paramVarArgs.aY(12, this.cdnControl);
      paramVarArgs.aY(13, this.videoFinalSize);
      paramVarArgs.e(14, 8, this.multiMediaInfo);
      if (this.codecInfo != null)
      {
        paramVarArgs.oE(15, this.codecInfo.computeSize());
        this.codecInfo.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(16, this.playDecoderType);
      AppMethodBeat.o(169008);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.remuxTime) + 0 + g.a.a.b.b.a.bM(2, this.remuxRetCode) + g.a.a.b.b.a.bM(3, this.cdnUploadTime) + g.a.a.b.b.a.bM(4, this.cdnUploadRetCode) + g.a.a.b.b.a.bM(5, this.zipTime) + g.a.a.b.b.a.bM(6, this.zipRetCode) + g.a.a.b.b.a.bM(7, this.mediaType);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.mediaId);
      }
      i = paramInt;
      if (this.origin != null) {
        i = paramInt + g.a.a.a.oD(9, this.origin.computeSize());
      }
      paramInt = i;
      if (this.target != null) {
        paramInt = i + g.a.a.a.oD(10, this.target.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.isBigFile) + g.a.a.b.b.a.bM(12, this.cdnControl) + g.a.a.b.b.a.bM(13, this.videoFinalSize) + g.a.a.a.c(14, 8, this.multiMediaInfo);
      paramInt = i;
      if (this.codecInfo != null) {
        paramInt = i + g.a.a.a.oD(15, this.codecInfo.computeSize());
      }
      i = g.a.a.b.b.a.bM(16, this.playDecoderType);
      AppMethodBeat.o(169008);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.multiMediaInfo.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
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
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169008);
        return -1;
      case 1: 
        localFinderMediaReportObject.remuxTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169008);
        return 0;
      case 2: 
        localFinderMediaReportObject.remuxRetCode = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169008);
        return 0;
      case 3: 
        localFinderMediaReportObject.cdnUploadTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169008);
        return 0;
      case 4: 
        localFinderMediaReportObject.cdnUploadRetCode = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169008);
        return 0;
      case 5: 
        localFinderMediaReportObject.zipTime = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169008);
        return 0;
      case 6: 
        localFinderMediaReportObject.zipRetCode = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169008);
        return 0;
      case 7: 
        localFinderMediaReportObject.mediaType = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169008);
        return 0;
      case 8: 
        localFinderMediaReportObject.mediaId = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(169008);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
        localFinderMediaReportObject.isBigFile = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169008);
        return 0;
      case 12: 
        localFinderMediaReportObject.cdnControl = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169008);
        return 0;
      case 13: 
        localFinderMediaReportObject.videoFinalSize = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(169008);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
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
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bea();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bea)localObject2).parseFrom((byte[])localObject1);
          }
          localFinderMediaReportObject.codecInfo = ((bea)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169008);
        return 0;
      }
      localFinderMediaReportObject.playDecoderType = ((g.a.a.a.a)localObject1).abFh.AK();
      AppMethodBeat.o(169008);
      return 0;
    }
    AppMethodBeat.o(169008);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMediaReportObject
 * JD-Core Version:    0.7.0.1
 */