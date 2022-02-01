package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cej
  extends dop
{
  public LinkedList<cey> MjC;
  public String Mjs;
  public String Mju;
  public String Mjv;
  public b Mjw;
  public int Mjx;
  public String Mjy;
  public String dNI;
  public String dmc;
  public String signature;
  public String url;
  
  public cej()
  {
    AppMethodBeat.i(82444);
    this.MjC = new LinkedList();
    AppMethodBeat.o(82444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82445);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.dNI != null) {
        paramVarArgs.e(3, this.dNI);
      }
      if (this.Mjs != null) {
        paramVarArgs.e(4, this.Mjs);
      }
      if (this.dmc != null) {
        paramVarArgs.e(5, this.dmc);
      }
      if (this.Mju != null) {
        paramVarArgs.e(6, this.Mju);
      }
      if (this.signature != null) {
        paramVarArgs.e(7, this.signature);
      }
      if (this.Mjv != null) {
        paramVarArgs.e(8, this.Mjv);
      }
      if (this.Mjw != null) {
        paramVarArgs.c(9, this.Mjw);
      }
      paramVarArgs.aM(10, this.Mjx);
      paramVarArgs.e(11, 8, this.MjC);
      if (this.Mjy != null) {
        paramVarArgs.e(12, this.Mjy);
      }
      AppMethodBeat.o(82445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1046;
      }
    }
    label1046:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dNI);
      }
      paramInt = i;
      if (this.Mjs != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mjs);
      }
      i = paramInt;
      if (this.dmc != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dmc);
      }
      paramInt = i;
      if (this.Mju != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mju);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.signature);
      }
      paramInt = i;
      if (this.Mjv != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Mjv);
      }
      i = paramInt;
      if (this.Mjw != null) {
        i = paramInt + g.a.a.b.b.a.b(9, this.Mjw);
      }
      i = i + g.a.a.b.b.a.bu(10, this.Mjx) + g.a.a.a.c(11, 8, this.MjC);
      paramInt = i;
      if (this.Mjy != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.Mjy);
      }
      AppMethodBeat.o(82445);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MjC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cej localcej = (cej)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82445);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcej.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82445);
          return 0;
        case 2: 
          localcej.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 3: 
          localcej.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 4: 
          localcej.Mjs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 5: 
          localcej.dmc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 6: 
          localcej.Mju = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 7: 
          localcej.signature = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 8: 
          localcej.Mjv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82445);
          return 0;
        case 9: 
          localcej.Mjw = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(82445);
          return 0;
        case 10: 
          localcej.Mjx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(82445);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cey();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cey)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcej.MjC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82445);
          return 0;
        }
        localcej.Mjy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(82445);
        return 0;
      }
      AppMethodBeat.o(82445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cej
 * JD-Core Version:    0.7.0.1
 */