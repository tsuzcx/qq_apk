package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayj
  extends cvw
{
  public String DnK;
  public String GPg;
  public String GPh;
  public String Gds;
  public String GtF;
  public String oOY;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GtF == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.GPg == null)
      {
        paramVarArgs = new b("Not all required fields were included: group_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.DnK == null)
      {
        paramVarArgs = new b("Not all required fields were included: time_stamp");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.oOY == null)
      {
        paramVarArgs = new b("Not all required fields were included: nonce_str");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.signature == null)
      {
        paramVarArgs = new b("Not all required fields were included: signature");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.Gds == null)
      {
        paramVarArgs = new b("Not all required fields were included: from_url");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GtF != null) {
        paramVarArgs.d(2, this.GtF);
      }
      if (this.GPg != null) {
        paramVarArgs.d(3, this.GPg);
      }
      if (this.DnK != null) {
        paramVarArgs.d(4, this.DnK);
      }
      if (this.oOY != null) {
        paramVarArgs.d(5, this.oOY);
      }
      if (this.signature != null) {
        paramVarArgs.d(6, this.signature);
      }
      if (this.Gds != null) {
        paramVarArgs.d(7, this.Gds);
      }
      if (this.GPh != null) {
        paramVarArgs.d(8, this.GPh);
      }
      AppMethodBeat.o(124506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GtF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GtF);
      }
      i = paramInt;
      if (this.GPg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GPg);
      }
      paramInt = i;
      if (this.DnK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DnK);
      }
      i = paramInt;
      if (this.oOY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oOY);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.signature);
      }
      i = paramInt;
      if (this.Gds != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gds);
      }
      paramInt = i;
      if (this.GPh != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GPh);
      }
      AppMethodBeat.o(124506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GtF == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.GPg == null)
        {
          paramVarArgs = new b("Not all required fields were included: group_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.DnK == null)
        {
          paramVarArgs = new b("Not all required fields were included: time_stamp");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.oOY == null)
        {
          paramVarArgs = new b("Not all required fields were included: nonce_str");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.signature == null)
        {
          paramVarArgs = new b("Not all required fields were included: signature");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.Gds == null)
        {
          paramVarArgs = new b("Not all required fields were included: from_url");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayj localayj = (ayj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124506);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localayj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124506);
          return 0;
        case 2: 
          localayj.GtF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 3: 
          localayj.GPg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 4: 
          localayj.DnK = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 5: 
          localayj.oOY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 6: 
          localayj.signature = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 7: 
          localayj.Gds = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124506);
          return 0;
        }
        localayj.GPh = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124506);
        return 0;
      }
      AppMethodBeat.o(124506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayj
 * JD-Core Version:    0.7.0.1
 */