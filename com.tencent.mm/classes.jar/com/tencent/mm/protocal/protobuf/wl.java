package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wl
  extends dyl
{
  public String InV;
  public String SiM;
  public String SiN;
  public String SiO;
  public int amount;
  public String fHb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72435);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fHb != null) {
        paramVarArgs.f(2, this.fHb);
      }
      if (this.SiO != null) {
        paramVarArgs.f(3, this.SiO);
      }
      if (this.InV != null) {
        paramVarArgs.f(4, this.InV);
      }
      paramVarArgs.aY(5, this.amount);
      if (this.SiN != null) {
        paramVarArgs.f(6, this.SiN);
      }
      if (this.SiM != null) {
        paramVarArgs.f(7, this.SiM);
      }
      AppMethodBeat.o(72435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label636;
      }
    }
    label636:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fHb != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fHb);
      }
      i = paramInt;
      if (this.SiO != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SiO);
      }
      paramInt = i;
      if (this.InV != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.InV);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.amount);
      paramInt = i;
      if (this.SiN != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SiN);
      }
      i = paramInt;
      if (this.SiM != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.SiM);
      }
      AppMethodBeat.o(72435);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        wl localwl = (wl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72435);
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
            localwl.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(72435);
          return 0;
        case 2: 
          localwl.fHb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 3: 
          localwl.SiO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 4: 
          localwl.InV = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 5: 
          localwl.amount = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72435);
          return 0;
        case 6: 
          localwl.SiN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72435);
          return 0;
        }
        localwl.SiM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72435);
        return 0;
      }
      AppMethodBeat.o(72435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wl
 * JD-Core Version:    0.7.0.1
 */