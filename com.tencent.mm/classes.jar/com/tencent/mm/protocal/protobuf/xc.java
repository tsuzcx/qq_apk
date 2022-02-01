package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class xc
  extends dyl
{
  public String ImY;
  public String Ine;
  public String Inf;
  public long Ipu;
  public String SiM;
  public String fHb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72450);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fHb == null)
      {
        paramVarArgs = new b("Not all required fields were included: req_key");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.Inf == null)
      {
        paramVarArgs = new b("Not all required fields were included: transfer_id");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.Ine == null)
      {
        paramVarArgs = new b("Not all required fields were included: transaction_id");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.ImY == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_openid");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fHb != null) {
        paramVarArgs.f(2, this.fHb);
      }
      if (this.Inf != null) {
        paramVarArgs.f(3, this.Inf);
      }
      if (this.Ine != null) {
        paramVarArgs.f(4, this.Ine);
      }
      if (this.ImY != null) {
        paramVarArgs.f(5, this.ImY);
      }
      paramVarArgs.bm(6, this.Ipu);
      if (this.SiM != null) {
        paramVarArgs.f(7, this.SiM);
      }
      AppMethodBeat.o(72450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label828;
      }
    }
    label828:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fHb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fHb);
      }
      i = paramInt;
      if (this.Inf != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Inf);
      }
      paramInt = i;
      if (this.Ine != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Ine);
      }
      i = paramInt;
      if (this.ImY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.ImY);
      }
      i += g.a.a.b.b.a.p(6, this.Ipu);
      paramInt = i;
      if (this.SiM != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.SiM);
      }
      AppMethodBeat.o(72450);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fHb == null)
        {
          paramVarArgs = new b("Not all required fields were included: req_key");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.Inf == null)
        {
          paramVarArgs = new b("Not all required fields were included: transfer_id");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.Ine == null)
        {
          paramVarArgs = new b("Not all required fields were included: transaction_id");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.ImY == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_openid");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72450);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        xc localxc = (xc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72450);
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
            localxc.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72450);
          return 0;
        case 2: 
          localxc.fHb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 3: 
          localxc.Inf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 4: 
          localxc.Ine = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 5: 
          localxc.ImY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 6: 
          localxc.Ipu = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(72450);
          return 0;
        }
        localxc.SiM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72450);
        return 0;
      }
      AppMethodBeat.o(72450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xc
 * JD-Core Version:    0.7.0.1
 */