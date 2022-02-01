package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apq
  extends erp
{
  public String YBW;
  public String YOn;
  public String YOs;
  public int ZwR;
  public int ZwS;
  public String ZwT;
  public String ZwU;
  public String ZwV;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259337);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.YBW != null) {
        paramVarArgs.g(3, this.YBW);
      }
      paramVarArgs.bS(4, this.ZwR);
      paramVarArgs.bS(5, this.ZwS);
      if (this.YOn != null) {
        paramVarArgs.g(6, this.YOn);
      }
      if (this.ZwT != null) {
        paramVarArgs.g(7, this.ZwT);
      }
      if (this.YOs != null) {
        paramVarArgs.g(8, this.YOs);
      }
      if (this.ZwU != null) {
        paramVarArgs.g(9, this.ZwU);
      }
      if (this.ZwV != null) {
        paramVarArgs.g(10, this.ZwV);
      }
      AppMethodBeat.o(259337);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label800;
      }
    }
    label800:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.YBW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YBW);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.ZwR) + i.a.a.b.b.a.cJ(5, this.ZwS);
      paramInt = i;
      if (this.YOn != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YOn);
      }
      i = paramInt;
      if (this.ZwT != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZwT);
      }
      paramInt = i;
      if (this.YOs != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YOs);
      }
      i = paramInt;
      if (this.ZwU != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZwU);
      }
      paramInt = i;
      if (this.ZwV != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ZwV);
      }
      AppMethodBeat.o(259337);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259337);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        apq localapq = (apq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259337);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localapq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259337);
          return 0;
        case 2: 
          localapq.vhX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259337);
          return 0;
        case 3: 
          localapq.YBW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259337);
          return 0;
        case 4: 
          localapq.ZwR = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259337);
          return 0;
        case 5: 
          localapq.ZwS = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259337);
          return 0;
        case 6: 
          localapq.YOn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259337);
          return 0;
        case 7: 
          localapq.ZwT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259337);
          return 0;
        case 8: 
          localapq.YOs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259337);
          return 0;
        case 9: 
          localapq.ZwU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259337);
          return 0;
        }
        localapq.ZwV = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259337);
        return 0;
      }
      AppMethodBeat.o(259337);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apq
 * JD-Core Version:    0.7.0.1
 */