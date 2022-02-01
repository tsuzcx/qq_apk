package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class adm
  extends erp
{
  public String YBL;
  public String YBM;
  public String ZlX;
  public String cli_msg_id;
  public long mMJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257589);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.mMJ);
      if (this.YBL != null) {
        paramVarArgs.g(3, this.YBL);
      }
      if (this.cli_msg_id != null) {
        paramVarArgs.g(4, this.cli_msg_id);
      }
      if (this.YBM != null) {
        paramVarArgs.g(5, this.YBM);
      }
      if (this.ZlX != null) {
        paramVarArgs.g(6, this.ZlX);
      }
      AppMethodBeat.o(257589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.mMJ);
      paramInt = i;
      if (this.YBL != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YBL);
      }
      i = paramInt;
      if (this.cli_msg_id != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.cli_msg_id);
      }
      paramInt = i;
      if (this.YBM != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YBM);
      }
      i = paramInt;
      if (this.ZlX != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZlX);
      }
      AppMethodBeat.o(257589);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        adm localadm = (adm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257589);
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
            localadm.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257589);
          return 0;
        case 2: 
          localadm.mMJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(257589);
          return 0;
        case 3: 
          localadm.YBL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257589);
          return 0;
        case 4: 
          localadm.cli_msg_id = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257589);
          return 0;
        case 5: 
          localadm.YBM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257589);
          return 0;
        }
        localadm.ZlX = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257589);
        return 0;
      }
      AppMethodBeat.o(257589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adm
 * JD-Core Version:    0.7.0.1
 */