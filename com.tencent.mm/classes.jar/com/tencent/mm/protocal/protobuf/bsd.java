package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsd
  extends erp
{
  public String YIZ;
  public int aaab;
  public int aaac;
  public long mMJ;
  public long object_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259934);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(2, this.YIZ);
      }
      paramVarArgs.bv(3, this.object_id);
      paramVarArgs.bv(4, this.mMJ);
      paramVarArgs.bS(5, this.aaab);
      paramVarArgs.bS(6, this.aaac);
      paramVarArgs.bS(7, this.scene);
      AppMethodBeat.o(259934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YIZ);
      }
      paramInt = i.a.a.b.b.a.q(3, this.object_id);
      int j = i.a.a.b.b.a.q(4, this.mMJ);
      int k = i.a.a.b.b.a.cJ(5, this.aaab);
      int m = i.a.a.b.b.a.cJ(6, this.aaac);
      int n = i.a.a.b.b.a.cJ(7, this.scene);
      AppMethodBeat.o(259934);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259934);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bsd localbsd = (bsd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259934);
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
            localbsd.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259934);
          return 0;
        case 2: 
          localbsd.YIZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259934);
          return 0;
        case 3: 
          localbsd.object_id = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259934);
          return 0;
        case 4: 
          localbsd.mMJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259934);
          return 0;
        case 5: 
          localbsd.aaab = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259934);
          return 0;
        case 6: 
          localbsd.aaac = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259934);
          return 0;
        }
        localbsd.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259934);
        return 0;
      }
      AppMethodBeat.o(259934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsd
 * JD-Core Version:    0.7.0.1
 */