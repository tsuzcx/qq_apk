package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsy
  extends erp
{
  public long GOo;
  public atz ZHY;
  public String aaaG;
  public String aaaH;
  public String aaaI;
  public int scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259769);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZHY != null)
      {
        paramVarArgs.qD(2, this.ZHY.computeSize());
        this.ZHY.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      if (this.aaaG != null) {
        paramVarArgs.g(4, this.aaaG);
      }
      if (this.aaaH != null) {
        paramVarArgs.g(5, this.aaaH);
      }
      if (this.aaaI != null) {
        paramVarArgs.g(6, this.aaaI);
      }
      paramVarArgs.bv(7, this.GOo);
      paramVarArgs.bS(8, this.scene);
      AppMethodBeat.o(259769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label754;
      }
    }
    label754:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZHY != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZHY.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.username);
      }
      paramInt = i;
      if (this.aaaG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaaG);
      }
      i = paramInt;
      if (this.aaaH != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaaH);
      }
      paramInt = i;
      if (this.aaaI != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaaI);
      }
      i = i.a.a.b.b.a.q(7, this.GOo);
      int j = i.a.a.b.b.a.cJ(8, this.scene);
      AppMethodBeat.o(259769);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259769);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bsy localbsy = (bsy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259769);
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
            localbsy.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259769);
          return 0;
        case 2: 
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
            localbsy.ZHY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259769);
          return 0;
        case 3: 
          localbsy.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259769);
          return 0;
        case 4: 
          localbsy.aaaG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259769);
          return 0;
        case 5: 
          localbsy.aaaH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259769);
          return 0;
        case 6: 
          localbsy.aaaI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259769);
          return 0;
        case 7: 
          localbsy.GOo = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259769);
          return 0;
        }
        localbsy.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259769);
        return 0;
      }
      AppMethodBeat.o(259769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsy
 * JD-Core Version:    0.7.0.1
 */