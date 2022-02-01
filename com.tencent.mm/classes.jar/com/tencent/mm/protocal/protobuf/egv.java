package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egv
  extends erp
{
  public String ZoT;
  public int aaBJ;
  public String abmh;
  public long abmi;
  public String request_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259241);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.request_id != null) {
        paramVarArgs.g(2, this.request_id);
      }
      if (this.abmh != null) {
        paramVarArgs.g(3, this.abmh);
      }
      paramVarArgs.bS(4, this.aaBJ);
      paramVarArgs.bv(5, this.abmi);
      paramVarArgs.bS(100, this.scene);
      if (this.ZoT != null) {
        paramVarArgs.g(101, this.ZoT);
      }
      AppMethodBeat.o(259241);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label620;
      }
    }
    label620:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.request_id);
      }
      i = paramInt;
      if (this.abmh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abmh);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.aaBJ) + i.a.a.b.b.a.q(5, this.abmi) + i.a.a.b.b.a.cJ(100, this.scene);
      paramInt = i;
      if (this.ZoT != null) {
        paramInt = i + i.a.a.b.b.a.h(101, this.ZoT);
      }
      AppMethodBeat.o(259241);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259241);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        egv localegv = (egv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259241);
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
            localegv.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259241);
          return 0;
        case 2: 
          localegv.request_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259241);
          return 0;
        case 3: 
          localegv.abmh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259241);
          return 0;
        case 4: 
          localegv.aaBJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259241);
          return 0;
        case 5: 
          localegv.abmi = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259241);
          return 0;
        case 100: 
          localegv.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259241);
          return 0;
        }
        localegv.ZoT = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259241);
        return 0;
      }
      AppMethodBeat.o(259241);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egv
 * JD-Core Version:    0.7.0.1
 */