package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aqu
  extends erp
{
  public String YQb;
  public b ZxO;
  public long Zyc;
  public String Zyd;
  public String Zye;
  public int Zyf;
  public float Zyg;
  public int Zyh;
  public String appid;
  public int source;
  public int zRU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104363);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(2, this.appid);
      }
      paramVarArgs.bv(3, this.Zyc);
      if (this.YQb != null) {
        paramVarArgs.g(4, this.YQb);
      }
      if (this.Zyd != null) {
        paramVarArgs.g(5, this.Zyd);
      }
      if (this.Zye != null) {
        paramVarArgs.g(6, this.Zye);
      }
      paramVarArgs.bS(7, this.source);
      paramVarArgs.bS(8, this.Zyf);
      paramVarArgs.bS(9, this.zRU);
      paramVarArgs.l(10, this.Zyg);
      paramVarArgs.bS(11, this.Zyh);
      if (this.ZxO != null) {
        paramVarArgs.d(12, this.ZxO);
      }
      AppMethodBeat.o(104363);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label855;
      }
    }
    label855:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.appid);
      }
      i += i.a.a.b.b.a.q(3, this.Zyc);
      paramInt = i;
      if (this.YQb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YQb);
      }
      i = paramInt;
      if (this.Zyd != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zyd);
      }
      paramInt = i;
      if (this.Zye != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zye);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.source) + i.a.a.b.b.a.cJ(8, this.Zyf) + i.a.a.b.b.a.cJ(9, this.zRU) + (i.a.a.b.b.a.ko(10) + 4) + i.a.a.b.b.a.cJ(11, this.Zyh);
      paramInt = i;
      if (this.ZxO != null) {
        paramInt = i + i.a.a.b.b.a.c(12, this.ZxO);
      }
      AppMethodBeat.o(104363);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104363);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aqu localaqu = (aqu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104363);
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
            localaqu.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(104363);
          return 0;
        case 2: 
          localaqu.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 3: 
          localaqu.Zyc = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(104363);
          return 0;
        case 4: 
          localaqu.YQb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 5: 
          localaqu.Zyd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 6: 
          localaqu.Zye = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 7: 
          localaqu.source = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104363);
          return 0;
        case 8: 
          localaqu.Zyf = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104363);
          return 0;
        case 9: 
          localaqu.zRU = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104363);
          return 0;
        case 10: 
          localaqu.Zyg = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(104363);
          return 0;
        case 11: 
          localaqu.Zyh = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104363);
          return 0;
        }
        localaqu.ZxO = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(104363);
        return 0;
      }
      AppMethodBeat.o(104363);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqu
 * JD-Core Version:    0.7.0.1
 */