package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.a.aa;
import java.util.LinkedList;

public final class dst
  extends esc
{
  public String Mcq;
  public String ZTA;
  public String ZTC;
  public String ZTy;
  public String ZWV;
  public String aaYr;
  public long aaYs;
  public aa aaYt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259652);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Mcq != null) {
        paramVarArgs.g(2, this.Mcq);
      }
      if (this.ZTy != null) {
        paramVarArgs.g(3, this.ZTy);
      }
      if (this.aaYr != null) {
        paramVarArgs.g(4, this.aaYr);
      }
      if (this.ZTA != null) {
        paramVarArgs.g(5, this.ZTA);
      }
      if (this.ZTC != null) {
        paramVarArgs.g(6, this.ZTC);
      }
      paramVarArgs.bv(7, this.aaYs);
      if (this.ZWV != null) {
        paramVarArgs.g(8, this.ZWV);
      }
      if (this.aaYt != null)
      {
        paramVarArgs.qD(9, this.aaYt.computeSize());
        this.aaYt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259652);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mcq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Mcq);
      }
      i = paramInt;
      if (this.ZTy != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZTy);
      }
      paramInt = i;
      if (this.aaYr != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaYr);
      }
      i = paramInt;
      if (this.ZTA != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZTA);
      }
      paramInt = i;
      if (this.ZTC != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZTC);
      }
      i = paramInt + i.a.a.b.b.a.q(7, this.aaYs);
      paramInt = i;
      if (this.ZWV != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZWV);
      }
      i = paramInt;
      if (this.aaYt != null) {
        i = paramInt + i.a.a.a.qC(9, this.aaYt.computeSize());
      }
      AppMethodBeat.o(259652);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259652);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dst localdst = (dst)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259652);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localdst.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259652);
          return 0;
        case 2: 
          localdst.Mcq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259652);
          return 0;
        case 3: 
          localdst.ZTy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259652);
          return 0;
        case 4: 
          localdst.aaYr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259652);
          return 0;
        case 5: 
          localdst.ZTA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259652);
          return 0;
        case 6: 
          localdst.ZTC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259652);
          return 0;
        case 7: 
          localdst.aaYs = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259652);
          return 0;
        case 8: 
          localdst.ZWV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259652);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aa)localObject2).parseFrom((byte[])localObject1);
          }
          localdst.aaYt = ((aa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259652);
        return 0;
      }
      AppMethodBeat.o(259652);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dst
 * JD-Core Version:    0.7.0.1
 */