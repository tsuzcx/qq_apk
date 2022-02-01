package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fnj
  extends dyl
{
  public int SEl;
  public LinkedList<String> ULK;
  public boolean ULL;
  public String ULM;
  public boolean ULN;
  public boolean ULO;
  public String Uub;
  public String appid;
  
  public fnj()
  {
    AppMethodBeat.i(153313);
    this.ULK = new LinkedList();
    AppMethodBeat.o(153313);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153314);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      paramVarArgs.e(3, 1, this.ULK);
      paramVarArgs.co(4, this.ULL);
      if (this.ULM != null) {
        paramVarArgs.f(5, this.ULM);
      }
      paramVarArgs.co(6, this.ULN);
      if (this.Uub != null) {
        paramVarArgs.f(7, this.Uub);
      }
      paramVarArgs.co(8, this.ULO);
      paramVarArgs.aY(9, this.SEl);
      AppMethodBeat.o(153314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label704;
      }
    }
    label704:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.appid);
      }
      i = i + g.a.a.a.c(3, 1, this.ULK) + (g.a.a.b.b.a.gL(4) + 1);
      paramInt = i;
      if (this.ULM != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ULM);
      }
      i = paramInt + (g.a.a.b.b.a.gL(6) + 1);
      paramInt = i;
      if (this.Uub != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Uub);
      }
      i = g.a.a.b.b.a.gL(8);
      int j = g.a.a.b.b.a.bM(9, this.SEl);
      AppMethodBeat.o(153314);
      return paramInt + (i + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ULK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fnj localfnj = (fnj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153314);
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
            localfnj.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(153314);
          return 0;
        case 2: 
          localfnj.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 3: 
          localfnj.ULK.add(((g.a.a.a.a)localObject).abFh.readString());
          AppMethodBeat.o(153314);
          return 0;
        case 4: 
          localfnj.ULL = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(153314);
          return 0;
        case 5: 
          localfnj.ULM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 6: 
          localfnj.ULN = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(153314);
          return 0;
        case 7: 
          localfnj.Uub = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 8: 
          localfnj.ULO = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(153314);
          return 0;
        }
        localfnj.SEl = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153314);
        return 0;
      }
      AppMethodBeat.o(153314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnj
 * JD-Core Version:    0.7.0.1
 */