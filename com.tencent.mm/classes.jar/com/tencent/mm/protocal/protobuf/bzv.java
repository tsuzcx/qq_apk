package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bzv
  extends cqk
{
  public String DXT;
  public cfz DXV;
  public String FoF;
  public boolean FoG;
  public boolean FoH;
  public int nWx;
  public String nWy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72529);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72529);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      if (this.FoF != null) {
        paramVarArgs.d(4, this.FoF);
      }
      if (this.DXT != null) {
        paramVarArgs.d(7, this.DXT);
      }
      if (this.DXV != null)
      {
        paramVarArgs.ln(8, this.DXV.computeSize());
        this.DXV.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(9, this.FoG);
      paramVarArgs.bl(10, this.FoH);
      AppMethodBeat.o(72529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.FoF != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FoF);
      }
      paramInt = i;
      if (this.DXT != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DXT);
      }
      i = paramInt;
      if (this.DXV != null) {
        i = paramInt + f.a.a.a.lm(8, this.DXV.computeSize());
      }
      paramInt = f.a.a.b.b.a.fK(9);
      int j = f.a.a.b.b.a.fK(10);
      AppMethodBeat.o(72529);
      return i + (paramInt + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bzv localbzv = (bzv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(72529);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 2: 
          localbzv.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72529);
          return 0;
        case 3: 
          localbzv.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 4: 
          localbzv.FoF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 7: 
          localbzv.DXT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72529);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbzv.DXV = ((cfz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72529);
          return 0;
        case 9: 
          localbzv.FoG = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(72529);
          return 0;
        }
        localbzv.FoH = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(72529);
        return 0;
      }
      AppMethodBeat.o(72529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzv
 * JD-Core Version:    0.7.0.1
 */