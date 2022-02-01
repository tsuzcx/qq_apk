package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bak
  extends erp
{
  public atz YIY;
  public int ZFJ;
  public int ZLh;
  public String ZLi;
  public long ZLj;
  public long ZLk;
  public String ZLl;
  public boolean ZLm;
  public long ZLn;
  public b ZLo;
  public String ZLp;
  public String waL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260131);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZLh);
      if (this.waL != null) {
        paramVarArgs.g(3, this.waL);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(4, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      if (this.ZLi != null) {
        paramVarArgs.g(5, this.ZLi);
      }
      paramVarArgs.bv(6, this.ZLj);
      paramVarArgs.bv(7, this.ZLk);
      if (this.ZLl != null) {
        paramVarArgs.g(8, this.ZLl);
      }
      paramVarArgs.bS(9, this.ZFJ);
      paramVarArgs.di(10, this.ZLm);
      paramVarArgs.bv(11, this.ZLn);
      if (this.ZLo != null) {
        paramVarArgs.d(12, this.ZLo);
      }
      if (this.ZLp != null) {
        paramVarArgs.g(13, this.ZLp);
      }
      AppMethodBeat.o(260131);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label990;
      }
    }
    label990:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZLh);
      paramInt = i;
      if (this.waL != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.waL);
      }
      i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(4, this.YIY.computeSize());
      }
      paramInt = i;
      if (this.ZLi != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZLi);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.ZLj) + i.a.a.b.b.a.q(7, this.ZLk);
      paramInt = i;
      if (this.ZLl != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZLl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.ZFJ) + (i.a.a.b.b.a.ko(10) + 1) + i.a.a.b.b.a.q(11, this.ZLn);
      paramInt = i;
      if (this.ZLo != null) {
        paramInt = i + i.a.a.b.b.a.c(12, this.ZLo);
      }
      i = paramInt;
      if (this.ZLp != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.ZLp);
      }
      AppMethodBeat.o(260131);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260131);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bak localbak = (bak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260131);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbak.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260131);
          return 0;
        case 2: 
          localbak.ZLh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260131);
          return 0;
        case 3: 
          localbak.waL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260131);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbak.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260131);
          return 0;
        case 5: 
          localbak.ZLi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260131);
          return 0;
        case 6: 
          localbak.ZLj = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260131);
          return 0;
        case 7: 
          localbak.ZLk = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260131);
          return 0;
        case 8: 
          localbak.ZLl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260131);
          return 0;
        case 9: 
          localbak.ZFJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260131);
          return 0;
        case 10: 
          localbak.ZLm = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(260131);
          return 0;
        case 11: 
          localbak.ZLn = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260131);
          return 0;
        case 12: 
          localbak.ZLo = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260131);
          return 0;
        }
        localbak.ZLp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(260131);
        return 0;
      }
      AppMethodBeat.o(260131);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bak
 * JD-Core Version:    0.7.0.1
 */