package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wj
  extends dyl
{
  public String InV;
  public String RJf;
  public String SiM;
  public String SiN;
  public int amount;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RJf == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.InV == null)
      {
        paramVarArgs = new b("Not all required fields were included: trans_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.SiN == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_open_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RJf != null) {
        paramVarArgs.f(2, this.RJf);
      }
      if (this.InV != null) {
        paramVarArgs.f(3, this.InV);
      }
      if (this.SiM != null) {
        paramVarArgs.f(4, this.SiM);
      }
      if (this.SiN != null) {
        paramVarArgs.f(5, this.SiN);
      }
      paramVarArgs.aY(6, this.amount);
      AppMethodBeat.o(91412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label720;
      }
    }
    label720:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RJf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RJf);
      }
      i = paramInt;
      if (this.InV != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.InV);
      }
      paramInt = i;
      if (this.SiM != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SiM);
      }
      i = paramInt;
      if (this.SiN != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.SiN);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.amount);
      AppMethodBeat.o(91412);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RJf == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.InV == null)
        {
          paramVarArgs = new b("Not all required fields were included: trans_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.SiN == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_open_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        wj localwj = (wj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91412);
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
            localwj.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91412);
          return 0;
        case 2: 
          localwj.RJf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 3: 
          localwj.InV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 4: 
          localwj.SiM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 5: 
          localwj.SiN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91412);
          return 0;
        }
        localwj.amount = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91412);
        return 0;
      }
      AppMethodBeat.o(91412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wj
 * JD-Core Version:    0.7.0.1
 */