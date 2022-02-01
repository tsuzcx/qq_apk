package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsk
  extends com.tencent.mm.bw.a
{
  public String LRO;
  public String Lir;
  public String Lis;
  public String LoE;
  public String LoF;
  public cvx MUN;
  public int MUk;
  public String UserName;
  public String jfi;
  public int kdY;
  public String oUJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152685);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.oUJ != null) {
        paramVarArgs.e(2, this.oUJ);
      }
      if (this.LoE != null) {
        paramVarArgs.e(3, this.LoE);
      }
      if (this.LoF != null) {
        paramVarArgs.e(4, this.LoF);
      }
      paramVarArgs.aM(5, this.kdY);
      if (this.Lir != null) {
        paramVarArgs.e(6, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(7, this.Lis);
      }
      if (this.jfi != null) {
        paramVarArgs.e(8, this.jfi);
      }
      paramVarArgs.aM(9, this.MUk);
      if (this.MUN != null)
      {
        paramVarArgs.ni(10, this.MUN.computeSize());
        this.MUN.writeFields(paramVarArgs);
      }
      if (this.LRO != null) {
        paramVarArgs.e(11, this.LRO);
      }
      AppMethodBeat.o(152685);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label890;
      }
    }
    label890:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oUJ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.oUJ);
      }
      i = paramInt;
      if (this.LoE != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LoE);
      }
      paramInt = i;
      if (this.LoF != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LoF);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.kdY);
      paramInt = i;
      if (this.Lir != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lir);
      }
      i = paramInt;
      if (this.Lis != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Lis);
      }
      paramInt = i;
      if (this.jfi != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.jfi);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.MUk);
      paramInt = i;
      if (this.MUN != null) {
        paramInt = i + g.a.a.a.nh(10, this.MUN.computeSize());
      }
      i = paramInt;
      if (this.LRO != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LRO);
      }
      AppMethodBeat.o(152685);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152685);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dsk localdsk = (dsk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152685);
          return -1;
        case 1: 
          localdsk.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 2: 
          localdsk.oUJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 3: 
          localdsk.LoE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 4: 
          localdsk.LoF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 5: 
          localdsk.kdY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152685);
          return 0;
        case 6: 
          localdsk.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 7: 
          localdsk.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 8: 
          localdsk.jfi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 9: 
          localdsk.MUk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152685);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cvx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdsk.MUN = ((cvx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152685);
          return 0;
        }
        localdsk.LRO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152685);
        return 0;
      }
      AppMethodBeat.o(152685);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsk
 * JD-Core Version:    0.7.0.1
 */