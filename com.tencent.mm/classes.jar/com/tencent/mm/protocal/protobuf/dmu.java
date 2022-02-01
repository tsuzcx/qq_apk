package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmu
  extends cpx
{
  public String Eww;
  public String Ewx;
  public String Ewy;
  public boolean FUA;
  public boolean FUv;
  public LinkedList<String> FUw;
  public String FUx;
  public String MD5;
  public int Scene;
  
  public dmu()
  {
    AppMethodBeat.i(104842);
    this.FUw = new LinkedList();
    AppMethodBeat.o(104842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(2, this.MD5);
      }
      paramVarArgs.bl(3, this.FUA);
      paramVarArgs.bl(4, this.FUv);
      paramVarArgs.e(5, 1, this.FUw);
      if (this.Eww != null) {
        paramVarArgs.d(6, this.Eww);
      }
      if (this.FUx != null) {
        paramVarArgs.d(7, this.FUx);
      }
      if (this.Ewy != null) {
        paramVarArgs.d(8, this.Ewy);
      }
      if (this.Ewx != null) {
        paramVarArgs.d(9, this.Ewx);
      }
      paramVarArgs.aR(10, this.Scene);
      AppMethodBeat.o(104843);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.MD5);
      }
      i = i + (f.a.a.b.b.a.fK(3) + 1) + (f.a.a.b.b.a.fK(4) + 1) + f.a.a.a.c(5, 1, this.FUw);
      paramInt = i;
      if (this.Eww != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Eww);
      }
      i = paramInt;
      if (this.FUx != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FUx);
      }
      paramInt = i;
      if (this.Ewy != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Ewy);
      }
      i = paramInt;
      if (this.Ewx != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ewx);
      }
      paramInt = f.a.a.b.b.a.bx(10, this.Scene);
      AppMethodBeat.o(104843);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104843);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmu localdmu = (dmu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104843);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmu.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104843);
          return 0;
        case 2: 
          localdmu.MD5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 3: 
          localdmu.FUA = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(104843);
          return 0;
        case 4: 
          localdmu.FUv = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(104843);
          return 0;
        case 5: 
          localdmu.FUw.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(104843);
          return 0;
        case 6: 
          localdmu.Eww = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 7: 
          localdmu.FUx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 8: 
          localdmu.Ewy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104843);
          return 0;
        case 9: 
          localdmu.Ewx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104843);
          return 0;
        }
        localdmu.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(104843);
        return 0;
      }
      AppMethodBeat.o(104843);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmu
 * JD-Core Version:    0.7.0.1
 */