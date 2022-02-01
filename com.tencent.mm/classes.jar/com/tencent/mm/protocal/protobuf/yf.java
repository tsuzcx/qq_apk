package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yf
  extends dop
{
  public int Ljf;
  public LinkedList<dqi> Ljg;
  public String Ljh;
  public String Lji;
  public int Scene;
  public String hik;
  public String xNG;
  public String xNU;
  public int xub;
  
  public yf()
  {
    AppMethodBeat.i(124468);
    this.Ljg = new LinkedList();
    AppMethodBeat.o(124468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124469);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.xub);
      if (this.xNG != null) {
        paramVarArgs.e(3, this.xNG);
      }
      if (this.xNU != null) {
        paramVarArgs.e(4, this.xNU);
      }
      if (this.hik != null) {
        paramVarArgs.e(5, this.hik);
      }
      paramVarArgs.aM(6, this.Ljf);
      paramVarArgs.e(7, 8, this.Ljg);
      if (this.Ljh != null) {
        paramVarArgs.e(8, this.Ljh);
      }
      if (this.Lji != null) {
        paramVarArgs.e(9, this.Lji);
      }
      paramVarArgs.aM(10, this.Scene);
      AppMethodBeat.o(124469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.xub);
      paramInt = i;
      if (this.xNG != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.xNG);
      }
      i = paramInt;
      if (this.xNU != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.xNU);
      }
      paramInt = i;
      if (this.hik != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.hik);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.Ljf) + g.a.a.a.c(7, 8, this.Ljg);
      paramInt = i;
      if (this.Ljh != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Ljh);
      }
      i = paramInt;
      if (this.Lji != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.Lji);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.Scene);
      AppMethodBeat.o(124469);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Ljg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        yf localyf = (yf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124469);
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
            localyf.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 2: 
          localyf.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124469);
          return 0;
        case 3: 
          localyf.xNG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 4: 
          localyf.xNU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 5: 
          localyf.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 6: 
          localyf.Ljf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124469);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localyf.Ljg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124469);
          return 0;
        case 8: 
          localyf.Ljh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124469);
          return 0;
        case 9: 
          localyf.Lji = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124469);
          return 0;
        }
        localyf.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124469);
        return 0;
      }
      AppMethodBeat.o(124469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yf
 * JD-Core Version:    0.7.0.1
 */