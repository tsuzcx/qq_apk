package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class brc
  extends dyl
{
  public String MFH;
  public String OPc;
  public String RYS;
  public String SqC;
  public String TbX;
  public String signature;
  public String tyJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SqC == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.MFH == null)
      {
        paramVarArgs = new b("Not all required fields were included: group_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.OPc == null)
      {
        paramVarArgs = new b("Not all required fields were included: time_stamp");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.tyJ == null)
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
      if (this.RYS == null)
      {
        paramVarArgs = new b("Not all required fields were included: from_url");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SqC != null) {
        paramVarArgs.f(2, this.SqC);
      }
      if (this.MFH != null) {
        paramVarArgs.f(3, this.MFH);
      }
      if (this.OPc != null) {
        paramVarArgs.f(4, this.OPc);
      }
      if (this.tyJ != null) {
        paramVarArgs.f(5, this.tyJ);
      }
      if (this.signature != null) {
        paramVarArgs.f(6, this.signature);
      }
      if (this.RYS != null) {
        paramVarArgs.f(7, this.RYS);
      }
      if (this.TbX != null) {
        paramVarArgs.f(8, this.TbX);
      }
      AppMethodBeat.o(124506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1004;
      }
    }
    label1004:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SqC != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SqC);
      }
      i = paramInt;
      if (this.MFH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MFH);
      }
      paramInt = i;
      if (this.OPc != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.OPc);
      }
      i = paramInt;
      if (this.tyJ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.tyJ);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.signature);
      }
      i = paramInt;
      if (this.RYS != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RYS);
      }
      paramInt = i;
      if (this.TbX != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TbX);
      }
      AppMethodBeat.o(124506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SqC == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.MFH == null)
        {
          paramVarArgs = new b("Not all required fields were included: group_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.OPc == null)
        {
          paramVarArgs = new b("Not all required fields were included: time_stamp");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.tyJ == null)
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
        if (this.RYS == null)
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        brc localbrc = (brc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124506);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localbrc.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(124506);
          return 0;
        case 2: 
          localbrc.SqC = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 3: 
          localbrc.MFH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 4: 
          localbrc.OPc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 5: 
          localbrc.tyJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 6: 
          localbrc.signature = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 7: 
          localbrc.RYS = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(124506);
          return 0;
        }
        localbrc.TbX = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(124506);
        return 0;
      }
      AppMethodBeat.o(124506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brc
 * JD-Core Version:    0.7.0.1
 */