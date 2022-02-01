package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czz
  extends cqk
{
  public String DPS;
  public LinkedList<SnsObject> DXh;
  public String FJm;
  public int FJq;
  public int FJr;
  public dbd FJs;
  public int Fli;
  
  public czz()
  {
    AppMethodBeat.i(125776);
    this.DXh = new LinkedList();
    AppMethodBeat.o(125776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125777);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.FJs == null)
      {
        paramVarArgs = new b("Not all required fields were included: ServerConfig");
        AppMethodBeat.o(125777);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FJm != null) {
        paramVarArgs.d(2, this.FJm);
      }
      paramVarArgs.aR(3, this.Fli);
      paramVarArgs.e(4, 8, this.DXh);
      paramVarArgs.aR(5, this.FJq);
      if (this.DPS != null) {
        paramVarArgs.d(6, this.DPS);
      }
      paramVarArgs.aR(7, this.FJr);
      if (this.FJs != null)
      {
        paramVarArgs.ln(8, this.FJs.computeSize());
        this.FJs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FJm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FJm);
      }
      i = i + f.a.a.b.b.a.bx(3, this.Fli) + f.a.a.a.c(4, 8, this.DXh) + f.a.a.b.b.a.bx(5, this.FJq);
      paramInt = i;
      if (this.DPS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DPS);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.FJr);
      paramInt = i;
      if (this.FJs != null) {
        paramInt = i + f.a.a.a.lm(8, this.FJs.computeSize());
      }
      AppMethodBeat.o(125777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DXh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        if (this.FJs == null)
        {
          paramVarArgs = new b("Not all required fields were included: ServerConfig");
          AppMethodBeat.o(125777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czz localczz = (czz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125777);
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
            localczz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 2: 
          localczz.FJm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 3: 
          localczz.Fli = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125777);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczz.DXh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125777);
          return 0;
        case 5: 
          localczz.FJq = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125777);
          return 0;
        case 6: 
          localczz.DPS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(125777);
          return 0;
        case 7: 
          localczz.FJr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(125777);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localczz.FJs = ((dbd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125777);
        return 0;
      }
      AppMethodBeat.o(125777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czz
 * JD-Core Version:    0.7.0.1
 */