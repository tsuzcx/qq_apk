package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amv;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String BGs;
  public amv KBr;
  public String desc;
  public LinkedList<aml> iAd;
  public long rnM;
  public String title;
  
  public c()
  {
    AppMethodBeat.i(94808);
    this.iAd = new LinkedList();
    AppMethodBeat.o(94808);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94809);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      paramVarArgs.e(3, 8, this.iAd);
      if (this.BGs != null) {
        paramVarArgs.e(4, this.BGs);
      }
      if (this.KBr != null)
      {
        paramVarArgs.ni(5, this.KBr.computeSize());
        this.KBr.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(6, this.rnM);
      AppMethodBeat.o(94809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = g.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.desc);
      }
      i += g.a.a.a.c(3, 8, this.iAd);
      paramInt = i;
      if (this.BGs != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.BGs);
      }
      i = paramInt;
      if (this.KBr != null) {
        i = paramInt + g.a.a.a.nh(5, this.KBr.computeSize());
      }
      paramInt = g.a.a.b.b.a.r(6, this.rnM);
      AppMethodBeat.o(94809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.iAd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(94809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        c localc = (c)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94809);
          return -1;
        case 1: 
          localc.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 2: 
          localc.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aml();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aml)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localc.iAd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        case 4: 
          localc.BGs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(94809);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new amv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((amv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localc.KBr = ((amv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94809);
          return 0;
        }
        localc.rnM = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(94809);
        return 0;
      }
      AppMethodBeat.o(94809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.c
 * JD-Core Version:    0.7.0.1
 */