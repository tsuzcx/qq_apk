package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ba
  extends com.tencent.mm.bw.a
{
  public int KDZ;
  public String KEa;
  public String KEb;
  public int KEc;
  public int KEd;
  public String KEe;
  public int KEf;
  public String KEg;
  public String KEh;
  public int KEi;
  public String KEj;
  public String KEk;
  public int KEl;
  public ffh KEm;
  public ffe KEn;
  public String UserName;
  public String ked;
  public int oTW;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133142);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      paramVarArgs.aM(3, this.KDZ);
      if (this.KEa != null) {
        paramVarArgs.e(4, this.KEa);
      }
      if (this.KEb != null) {
        paramVarArgs.e(5, this.KEb);
      }
      if (this.ked != null) {
        paramVarArgs.e(6, this.ked);
      }
      paramVarArgs.aM(8, this.oTW);
      paramVarArgs.aM(9, this.KEc);
      paramVarArgs.aM(10, this.KEd);
      if (this.KEe != null) {
        paramVarArgs.e(11, this.KEe);
      }
      paramVarArgs.aM(12, this.KEf);
      if (this.KEg != null) {
        paramVarArgs.e(13, this.KEg);
      }
      if (this.KEh != null) {
        paramVarArgs.e(14, this.KEh);
      }
      paramVarArgs.aM(15, this.KEi);
      if (this.KEj != null) {
        paramVarArgs.e(16, this.KEj);
      }
      if (this.KEk != null) {
        paramVarArgs.e(17, this.KEk);
      }
      paramVarArgs.aM(18, this.KEl);
      if (this.KEm != null)
      {
        paramVarArgs.ni(19, this.KEm.computeSize());
        this.KEm.writeFields(paramVarArgs);
      }
      if (this.KEn != null)
      {
        paramVarArgs.ni(20, this.KEn.computeSize());
        this.KEn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133142);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1402;
      }
    }
    label1402:
    for (paramInt = g.a.a.b.b.a.f(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oUJ != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i += g.a.a.b.b.a.bu(3, this.KDZ);
      paramInt = i;
      if (this.KEa != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KEa);
      }
      i = paramInt;
      if (this.KEb != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KEb);
      }
      paramInt = i;
      if (this.ked != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.ked);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.oTW) + g.a.a.b.b.a.bu(9, this.KEc) + g.a.a.b.b.a.bu(10, this.KEd);
      paramInt = i;
      if (this.KEe != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.KEe);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.KEf);
      paramInt = i;
      if (this.KEg != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.KEg);
      }
      i = paramInt;
      if (this.KEh != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.KEh);
      }
      i += g.a.a.b.b.a.bu(15, this.KEi);
      paramInt = i;
      if (this.KEj != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.KEj);
      }
      i = paramInt;
      if (this.KEk != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.KEk);
      }
      i += g.a.a.b.b.a.bu(18, this.KEl);
      paramInt = i;
      if (this.KEm != null) {
        paramInt = i + g.a.a.a.nh(19, this.KEm.computeSize());
      }
      i = paramInt;
      if (this.KEn != null) {
        i = paramInt + g.a.a.a.nh(20, this.KEn.computeSize());
      }
      AppMethodBeat.o(133142);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(133142);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ba localba = (ba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(133142);
          return -1;
        case 1: 
          localba.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 2: 
          localba.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 3: 
          localba.KDZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133142);
          return 0;
        case 4: 
          localba.KEa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 5: 
          localba.KEb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 6: 
          localba.ked = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 8: 
          localba.oTW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133142);
          return 0;
        case 9: 
          localba.KEc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133142);
          return 0;
        case 10: 
          localba.KEd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133142);
          return 0;
        case 11: 
          localba.KEe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 12: 
          localba.KEf = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133142);
          return 0;
        case 13: 
          localba.KEg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 14: 
          localba.KEh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 15: 
          localba.KEi = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133142);
          return 0;
        case 16: 
          localba.KEj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 17: 
          localba.KEk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 18: 
          localba.KEl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133142);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ffh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ffh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localba.KEm = ((ffh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133142);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ffe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ffe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localba.KEn = ((ffe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133142);
        return 0;
      }
      AppMethodBeat.o(133142);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ba
 * JD-Core Version:    0.7.0.1
 */