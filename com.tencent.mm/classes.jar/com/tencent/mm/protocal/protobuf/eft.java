package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class eft
  extends erp
{
  public String YBL;
  public b YJa;
  public String cli_msg_id;
  public String content;
  public long mMJ;
  public int msg_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259426);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YJa != null) {
        paramVarArgs.d(2, this.YJa);
      }
      paramVarArgs.bS(3, this.msg_type);
      if (this.content != null) {
        paramVarArgs.g(4, this.content);
      }
      paramVarArgs.bv(5, this.mMJ);
      if (this.YBL != null) {
        paramVarArgs.g(6, this.YBL);
      }
      if (this.cli_msg_id != null) {
        paramVarArgs.g(7, this.cli_msg_id);
      }
      AppMethodBeat.o(259426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label616;
      }
    }
    label616:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.YJa);
      }
      i += i.a.a.b.b.a.cJ(3, this.msg_type);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.content);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.mMJ);
      paramInt = i;
      if (this.YBL != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YBL);
      }
      i = paramInt;
      if (this.cli_msg_id != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.cli_msg_id);
      }
      AppMethodBeat.o(259426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eft localeft = (eft)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259426);
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
            localeft.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259426);
          return 0;
        case 2: 
          localeft.YJa = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259426);
          return 0;
        case 3: 
          localeft.msg_type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259426);
          return 0;
        case 4: 
          localeft.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259426);
          return 0;
        case 5: 
          localeft.mMJ = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(259426);
          return 0;
        case 6: 
          localeft.YBL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259426);
          return 0;
        }
        localeft.cli_msg_id = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259426);
        return 0;
      }
      AppMethodBeat.o(259426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eft
 * JD-Core Version:    0.7.0.1
 */