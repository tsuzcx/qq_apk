package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eiw
  extends erp
{
  public long NlD;
  public long YSo;
  public String abhz;
  public int abnH;
  public long abnI;
  public int abnJ;
  public long abnK;
  public long appid;
  public int hAf;
  public int platform;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124539);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abnH);
      paramVarArgs.bv(3, this.abnI);
      paramVarArgs.bv(4, this.appid);
      paramVarArgs.bv(5, this.YSo);
      paramVarArgs.bS(6, this.abnJ);
      paramVarArgs.bS(7, this.scene);
      paramVarArgs.bS(8, this.hAf);
      paramVarArgs.bv(9, this.NlD);
      paramVarArgs.bv(10, this.abnK);
      paramVarArgs.bS(11, this.platform);
      if (this.abhz != null) {
        paramVarArgs.g(12, this.abhz);
      }
      AppMethodBeat.o(124539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label780;
      }
    }
    label780:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abnH) + i.a.a.b.b.a.q(3, this.abnI) + i.a.a.b.b.a.q(4, this.appid) + i.a.a.b.b.a.q(5, this.YSo) + i.a.a.b.b.a.cJ(6, this.abnJ) + i.a.a.b.b.a.cJ(7, this.scene) + i.a.a.b.b.a.cJ(8, this.hAf) + i.a.a.b.b.a.q(9, this.NlD) + i.a.a.b.b.a.q(10, this.abnK) + i.a.a.b.b.a.cJ(11, this.platform);
      paramInt = i;
      if (this.abhz != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abhz);
      }
      AppMethodBeat.o(124539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eiw localeiw = (eiw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124539);
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
            localeiw.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(124539);
          return 0;
        case 2: 
          localeiw.abnH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124539);
          return 0;
        case 3: 
          localeiw.abnI = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(124539);
          return 0;
        case 4: 
          localeiw.appid = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(124539);
          return 0;
        case 5: 
          localeiw.YSo = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(124539);
          return 0;
        case 6: 
          localeiw.abnJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124539);
          return 0;
        case 7: 
          localeiw.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124539);
          return 0;
        case 8: 
          localeiw.hAf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124539);
          return 0;
        case 9: 
          localeiw.NlD = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(124539);
          return 0;
        case 10: 
          localeiw.abnK = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(124539);
          return 0;
        case 11: 
          localeiw.platform = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(124539);
          return 0;
        }
        localeiw.abhz = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(124539);
        return 0;
      }
      AppMethodBeat.o(124539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiw
 * JD-Core Version:    0.7.0.1
 */