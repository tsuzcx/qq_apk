package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class FinderMediaReportObject
  extends com.tencent.mm.bw.a
{
  public int cdnUploadRetCode;
  public int cdnUploadTime;
  public String mediaId;
  public int mediaType;
  public FinderMediaReportInfo origin;
  public int remuxRetCode;
  public int remuxTime;
  public FinderMediaReportInfo target;
  public int zipRetCode;
  public int zipTime;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169008);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.remuxTime);
      paramVarArgs.aR(2, this.remuxRetCode);
      paramVarArgs.aR(3, this.cdnUploadTime);
      paramVarArgs.aR(4, this.cdnUploadRetCode);
      paramVarArgs.aR(5, this.zipTime);
      paramVarArgs.aR(6, this.zipRetCode);
      paramVarArgs.aR(7, this.mediaType);
      if (this.mediaId != null) {
        paramVarArgs.d(8, this.mediaId);
      }
      if (this.origin != null)
      {
        paramVarArgs.ln(9, this.origin.computeSize());
        this.origin.writeFields(paramVarArgs);
      }
      if (this.target != null)
      {
        paramVarArgs.ln(10, this.target.computeSize());
        this.target.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169008);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.remuxTime) + 0 + f.a.a.b.b.a.bx(2, this.remuxRetCode) + f.a.a.b.b.a.bx(3, this.cdnUploadTime) + f.a.a.b.b.a.bx(4, this.cdnUploadRetCode) + f.a.a.b.b.a.bx(5, this.zipTime) + f.a.a.b.b.a.bx(6, this.zipRetCode) + f.a.a.b.b.a.bx(7, this.mediaType);
      paramInt = i;
      if (this.mediaId != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.mediaId);
      }
      i = paramInt;
      if (this.origin != null) {
        i = paramInt + f.a.a.a.lm(9, this.origin.computeSize());
      }
      paramInt = i;
      if (this.target != null) {
        paramInt = i + f.a.a.a.lm(10, this.target.computeSize());
      }
      AppMethodBeat.o(169008);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        localFinderMediaReportObject.remuxTime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169008);
        return 0;
      case 2: 
        localFinderMediaReportObject.remuxRetCode = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169008);
        return 0;
      case 3: 
        localFinderMediaReportObject.cdnUploadTime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169008);
        return 0;
      case 4: 
        localFinderMediaReportObject.cdnUploadRetCode = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169008);
        return 0;
      case 5: 
        localFinderMediaReportObject.zipTime = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169008);
        return 0;
      case 6: 
        localFinderMediaReportObject.zipRetCode = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169008);
        return 0;
      case 7: 
        localFinderMediaReportObject.mediaType = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169008);
        return 0;
      case 8: 
        localFinderMediaReportObject.mediaId = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(169008);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
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
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
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
    }
    AppMethodBeat.o(169008);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.FinderMediaReportObject
 * JD-Core Version:    0.7.0.1
 */