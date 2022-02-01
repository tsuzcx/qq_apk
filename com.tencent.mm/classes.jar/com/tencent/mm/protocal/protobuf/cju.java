package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cju
  extends erp
{
  public String YPz;
  public String Zji;
  public ebs aaqS;
  public float aasn;
  public long aasp;
  public String aasq;
  public b aasr;
  public boolean aass;
  public String action_data;
  public int live_type;
  public String person_id;
  public int scene;
  public String xlr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104371);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.person_id != null) {
        paramVarArgs.g(2, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.g(3, this.action_data);
      }
      paramVarArgs.l(4, this.aasn);
      if (this.aasq != null) {
        paramVarArgs.g(5, this.aasq);
      }
      if (this.YPz != null) {
        paramVarArgs.g(6, this.YPz);
      }
      paramVarArgs.bS(7, this.scene);
      if (this.Zji != null) {
        paramVarArgs.g(8, this.Zji);
      }
      if (this.xlr != null) {
        paramVarArgs.g(9, this.xlr);
      }
      if (this.aaqS != null)
      {
        paramVarArgs.qD(10, this.aaqS.computeSize());
        this.aaqS.writeFields(paramVarArgs);
      }
      if (this.aasr != null) {
        paramVarArgs.d(11, this.aasr);
      }
      paramVarArgs.di(12, this.aass);
      paramVarArgs.bS(13, this.live_type);
      paramVarArgs.bv(14, this.aasp);
      AppMethodBeat.o(104371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1077;
      }
    }
    label1077:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.person_id != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.person_id);
      }
      i = paramInt;
      if (this.action_data != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.action_data);
      }
      i += i.a.a.b.b.a.ko(4) + 4;
      paramInt = i;
      if (this.aasq != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aasq);
      }
      i = paramInt;
      if (this.YPz != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YPz);
      }
      i += i.a.a.b.b.a.cJ(7, this.scene);
      paramInt = i;
      if (this.Zji != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Zji);
      }
      i = paramInt;
      if (this.xlr != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.xlr);
      }
      paramInt = i;
      if (this.aaqS != null) {
        paramInt = i + i.a.a.a.qC(10, this.aaqS.computeSize());
      }
      i = paramInt;
      if (this.aasr != null) {
        i = paramInt + i.a.a.b.b.a.c(11, this.aasr);
      }
      paramInt = i.a.a.b.b.a.ko(12);
      int j = i.a.a.b.b.a.cJ(13, this.live_type);
      int k = i.a.a.b.b.a.q(14, this.aasp);
      AppMethodBeat.o(104371);
      return i + (paramInt + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104371);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cju localcju = (cju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104371);
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
            localcju.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 2: 
          localcju.person_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 3: 
          localcju.action_data = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 4: 
          localcju.aasn = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(104371);
          return 0;
        case 5: 
          localcju.aasq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 6: 
          localcju.YPz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 7: 
          localcju.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104371);
          return 0;
        case 8: 
          localcju.Zji = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 9: 
          localcju.xlr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebs)localObject2).parseFrom((byte[])localObject1);
            }
            localcju.aaqS = ((ebs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 11: 
          localcju.aasr = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(104371);
          return 0;
        case 12: 
          localcju.aass = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(104371);
          return 0;
        case 13: 
          localcju.live_type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104371);
          return 0;
        }
        localcju.aasp = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(104371);
        return 0;
      }
      AppMethodBeat.o(104371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cju
 * JD-Core Version:    0.7.0.1
 */