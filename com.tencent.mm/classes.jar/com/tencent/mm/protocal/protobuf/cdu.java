package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdu
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String KSh;
  public String KSj;
  public String KSl;
  public String KSm;
  public String KSn;
  public eqv Mjm;
  public esh Mjn;
  public dbp Mjo;
  public String Title;
  public int iAb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212281);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.KSh != null) {
        paramVarArgs.e(2, this.KSh);
      }
      if (this.KSj != null) {
        paramVarArgs.e(3, this.KSj);
      }
      if (this.KSl != null) {
        paramVarArgs.e(4, this.KSl);
      }
      if (this.KSm != null) {
        paramVarArgs.e(5, this.KSm);
      }
      if (this.KSn != null) {
        paramVarArgs.e(6, this.KSn);
      }
      paramVarArgs.aM(7, this.iAb);
      paramVarArgs.aM(8, this.CreateTime);
      if (this.Mjm != null)
      {
        paramVarArgs.ni(9, this.Mjm.computeSize());
        this.Mjm.writeFields(paramVarArgs);
      }
      if (this.Mjn != null)
      {
        paramVarArgs.ni(10, this.Mjn.computeSize());
        this.Mjn.writeFields(paramVarArgs);
      }
      if (this.Mjo != null)
      {
        paramVarArgs.ni(11, this.Mjo.computeSize());
        this.Mjo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(212281);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label1078;
      }
    }
    label1078:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KSh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KSh);
      }
      i = paramInt;
      if (this.KSj != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KSj);
      }
      paramInt = i;
      if (this.KSl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KSl);
      }
      i = paramInt;
      if (this.KSm != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KSm);
      }
      paramInt = i;
      if (this.KSn != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KSn);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.iAb) + g.a.a.b.b.a.bu(8, this.CreateTime);
      paramInt = i;
      if (this.Mjm != null) {
        paramInt = i + g.a.a.a.nh(9, this.Mjm.computeSize());
      }
      i = paramInt;
      if (this.Mjn != null) {
        i = paramInt + g.a.a.a.nh(10, this.Mjn.computeSize());
      }
      paramInt = i;
      if (this.Mjo != null) {
        paramInt = i + g.a.a.a.nh(11, this.Mjo.computeSize());
      }
      AppMethodBeat.o(212281);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212281);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cdu localcdu = (cdu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212281);
          return -1;
        case 1: 
          localcdu.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212281);
          return 0;
        case 2: 
          localcdu.KSh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212281);
          return 0;
        case 3: 
          localcdu.KSj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212281);
          return 0;
        case 4: 
          localcdu.KSl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212281);
          return 0;
        case 5: 
          localcdu.KSm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212281);
          return 0;
        case 6: 
          localcdu.KSn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212281);
          return 0;
        case 7: 
          localcdu.iAb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212281);
          return 0;
        case 8: 
          localcdu.CreateTime = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212281);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eqv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eqv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcdu.Mjm = ((eqv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212281);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new esh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((esh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcdu.Mjn = ((esh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212281);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dbp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dbp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcdu.Mjo = ((dbp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212281);
        return 0;
      }
      AppMethodBeat.o(212281);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdu
 * JD-Core Version:    0.7.0.1
 */