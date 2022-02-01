package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class atz
  extends com.tencent.mm.bx.a
{
  public long Bjl;
  public int ZEp;
  public b ZEq;
  public int ZEr;
  public acx ZEs;
  public int ZEt;
  public LinkedList<bra> ZEu;
  public int scene;
  
  public atz()
  {
    AppMethodBeat.i(258099);
    this.ZEu = new LinkedList();
    AppMethodBeat.o(258099);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168937);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZEp);
      paramVarArgs.bS(2, this.scene);
      if (this.ZEq != null) {
        paramVarArgs.d(3, this.ZEq);
      }
      paramVarArgs.bS(4, this.ZEr);
      if (this.ZEs != null)
      {
        paramVarArgs.qD(5, this.ZEs.computeSize());
        this.ZEs.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.Bjl);
      paramVarArgs.bS(7, this.ZEt);
      paramVarArgs.e(8, 8, this.ZEu);
      AppMethodBeat.o(168937);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZEp) + 0 + i.a.a.b.b.a.cJ(2, this.scene);
      paramInt = i;
      if (this.ZEq != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZEq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.ZEr);
      paramInt = i;
      if (this.ZEs != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZEs.computeSize());
      }
      i = i.a.a.b.b.a.q(6, this.Bjl);
      int j = i.a.a.b.b.a.cJ(7, this.ZEt);
      int k = i.a.a.a.c(8, 8, this.ZEu);
      AppMethodBeat.o(168937);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZEu.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      atz localatz = (atz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168937);
        return -1;
      case 1: 
        localatz.ZEp = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168937);
        return 0;
      case 2: 
        localatz.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168937);
        return 0;
      case 3: 
        localatz.ZEq = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(168937);
        return 0;
      case 4: 
        localatz.ZEr = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168937);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acx)localObject2).parseFrom((byte[])localObject1);
          }
          localatz.ZEs = ((acx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168937);
        return 0;
      case 6: 
        localatz.Bjl = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(168937);
        return 0;
      case 7: 
        localatz.ZEt = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(168937);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bra();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bra)localObject2).parseFrom((byte[])localObject1);
        }
        localatz.ZEu.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(168937);
      return 0;
    }
    AppMethodBeat.o(168937);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atz
 * JD-Core Version:    0.7.0.1
 */