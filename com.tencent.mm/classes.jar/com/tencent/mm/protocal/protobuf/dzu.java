package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzu
  extends cqk
{
  public int Fwu;
  public int GfN;
  public int GfO;
  public String dlt;
  public String md5;
  public String url;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123686);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123686);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aR(4, this.version);
      paramVarArgs.aR(5, this.GfN);
      paramVarArgs.aR(6, this.Fwu);
      paramVarArgs.aR(7, this.GfO);
      if (this.dlt != null) {
        paramVarArgs.d(8, this.dlt);
      }
      AppMethodBeat.o(123686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label714;
      }
    }
    label714:
    for (int i = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bx(4, this.version) + f.a.a.b.b.a.bx(5, this.GfN) + f.a.a.b.b.a.bx(6, this.Fwu) + f.a.a.b.b.a.bx(7, this.GfO);
      paramInt = i;
      if (this.dlt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.dlt);
      }
      AppMethodBeat.o(123686);
      return paramInt;
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
          AppMethodBeat.o(123686);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123686);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzu localdzu = (dzu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123686);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123686);
          return 0;
        case 2: 
          localdzu.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 3: 
          localdzu.md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123686);
          return 0;
        case 4: 
          localdzu.version = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123686);
          return 0;
        case 5: 
          localdzu.GfN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123686);
          return 0;
        case 6: 
          localdzu.Fwu = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123686);
          return 0;
        case 7: 
          localdzu.GfO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123686);
          return 0;
        }
        localdzu.dlt = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123686);
        return 0;
      }
      AppMethodBeat.o(123686);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzu
 * JD-Core Version:    0.7.0.1
 */