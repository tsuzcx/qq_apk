package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cid
  extends com.tencent.mm.bw.a
{
  public String Hul;
  public bta Hum;
  public boolean Hun = false;
  public String action;
  public String className;
  public String dGe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122524);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.className != null) {
        paramVarArgs.d(1, this.className);
      }
      if (this.dGe != null) {
        paramVarArgs.d(2, this.dGe);
      }
      if (this.action != null) {
        paramVarArgs.d(3, this.action);
      }
      if (this.Hul != null) {
        paramVarArgs.d(4, this.Hul);
      }
      if (this.Hum != null)
      {
        paramVarArgs.lJ(5, this.Hum.computeSize());
        this.Hum.writeFields(paramVarArgs);
      }
      paramVarArgs.bC(6, this.Hun);
      AppMethodBeat.o(122524);
      return 0;
    }
    if (paramInt == 1) {
      if (this.className == null) {
        break label594;
      }
    }
    label594:
    for (int i = f.a.a.b.b.a.e(1, this.className) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dGe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dGe);
      }
      i = paramInt;
      if (this.action != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.action);
      }
      paramInt = i;
      if (this.Hul != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hul);
      }
      i = paramInt;
      if (this.Hum != null) {
        i = paramInt + f.a.a.a.lI(5, this.Hum.computeSize());
      }
      paramInt = f.a.a.b.b.a.amF(6);
      AppMethodBeat.o(122524);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122524);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cid localcid = (cid)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122524);
          return -1;
        case 1: 
          localcid.className = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 2: 
          localcid.dGe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 3: 
          localcid.action = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 4: 
          localcid.Hul = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122524);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bta();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bta)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcid.Hum = ((bta)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122524);
          return 0;
        }
        localcid.Hun = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(122524);
        return 0;
      }
      AppMethodBeat.o(122524);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cid
 * JD-Core Version:    0.7.0.1
 */