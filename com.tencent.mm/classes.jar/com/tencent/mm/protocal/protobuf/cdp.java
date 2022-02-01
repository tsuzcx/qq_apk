package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cdp
  extends com.tencent.mm.bx.a
{
  public String Vyi;
  public String YDA;
  public String YDH;
  public awq YGb;
  public String aanS;
  public b aanT;
  public rv aanU;
  public long mMJ;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257555);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGb != null)
      {
        paramVarArgs.qD(1, this.YGb.computeSize());
        this.YGb.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.scene);
      if (this.Vyi != null) {
        paramVarArgs.g(3, this.Vyi);
      }
      if (this.aanS != null) {
        paramVarArgs.g(4, this.aanS);
      }
      if (this.aanT != null) {
        paramVarArgs.d(5, this.aanT);
      }
      if (this.YDA != null) {
        paramVarArgs.g(6, this.YDA);
      }
      if (this.YDH != null) {
        paramVarArgs.g(7, this.YDH);
      }
      paramVarArgs.bv(8, this.mMJ);
      if (this.aanU != null)
      {
        paramVarArgs.qD(9, this.aanU.computeSize());
        this.aanU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGb == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = i.a.a.a.qC(1, this.YGb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.scene);
      paramInt = i;
      if (this.Vyi != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Vyi);
      }
      i = paramInt;
      if (this.aanS != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aanS);
      }
      paramInt = i;
      if (this.aanT != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.aanT);
      }
      i = paramInt;
      if (this.YDA != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YDA);
      }
      paramInt = i;
      if (this.YDH != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YDH);
      }
      i = paramInt + i.a.a.b.b.a.q(8, this.mMJ);
      paramInt = i;
      if (this.aanU != null) {
        paramInt = i + i.a.a.a.qC(9, this.aanU.computeSize());
      }
      AppMethodBeat.o(257555);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257555);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cdp localcdp = (cdp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257555);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awq)localObject2).parseFrom((byte[])localObject1);
            }
            localcdp.YGb = ((awq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257555);
          return 0;
        case 2: 
          localcdp.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257555);
          return 0;
        case 3: 
          localcdp.Vyi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257555);
          return 0;
        case 4: 
          localcdp.aanS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257555);
          return 0;
        case 5: 
          localcdp.aanT = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257555);
          return 0;
        case 6: 
          localcdp.YDA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257555);
          return 0;
        case 7: 
          localcdp.YDH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257555);
          return 0;
        case 8: 
          localcdp.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257555);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new rv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((rv)localObject2).parseFrom((byte[])localObject1);
          }
          localcdp.aanU = ((rv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257555);
        return 0;
      }
      AppMethodBeat.o(257555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdp
 * JD-Core Version:    0.7.0.1
 */