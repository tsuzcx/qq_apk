package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zf
  extends dyl
{
  public int CPw;
  public String Slp;
  public String Slq;
  public String Slr;
  public String Sls;
  public String Slt;
  public String Slu;
  public int Slv;
  public String Slw;
  public String fwr;
  public String lVG;
  public String lVt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63271);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lVt != null) {
        paramVarArgs.f(2, this.lVt);
      }
      if (this.fwr != null) {
        paramVarArgs.f(3, this.fwr);
      }
      if (this.Slp != null) {
        paramVarArgs.f(4, this.Slp);
      }
      if (this.Slq != null) {
        paramVarArgs.f(5, this.Slq);
      }
      if (this.Slr != null) {
        paramVarArgs.f(6, this.Slr);
      }
      if (this.Sls != null) {
        paramVarArgs.f(7, this.Sls);
      }
      if (this.Slt != null) {
        paramVarArgs.f(8, this.Slt);
      }
      if (this.lVG != null) {
        paramVarArgs.f(9, this.lVG);
      }
      paramVarArgs.aY(10, this.CPw);
      if (this.Slu != null) {
        paramVarArgs.f(11, this.Slu);
      }
      paramVarArgs.aY(12, this.Slv);
      if (this.Slw != null) {
        paramVarArgs.f(13, this.Slw);
      }
      AppMethodBeat.o(63271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label992;
      }
    }
    label992:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lVt != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVt);
      }
      i = paramInt;
      if (this.fwr != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fwr);
      }
      paramInt = i;
      if (this.Slp != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Slp);
      }
      i = paramInt;
      if (this.Slq != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Slq);
      }
      paramInt = i;
      if (this.Slr != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Slr);
      }
      i = paramInt;
      if (this.Sls != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Sls);
      }
      paramInt = i;
      if (this.Slt != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Slt);
      }
      i = paramInt;
      if (this.lVG != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.lVG);
      }
      i += g.a.a.b.b.a.bM(10, this.CPw);
      paramInt = i;
      if (this.Slu != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.Slu);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.Slv);
      paramInt = i;
      if (this.Slw != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.Slw);
      }
      AppMethodBeat.o(63271);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(63271);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        zf localzf = (zf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63271);
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
            localzf.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(63271);
          return 0;
        case 2: 
          localzf.lVt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 3: 
          localzf.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 4: 
          localzf.Slp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 5: 
          localzf.Slq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 6: 
          localzf.Slr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 7: 
          localzf.Sls = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 8: 
          localzf.Slt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 9: 
          localzf.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 10: 
          localzf.CPw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(63271);
          return 0;
        case 11: 
          localzf.Slu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 12: 
          localzf.Slv = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(63271);
          return 0;
        }
        localzf.Slw = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(63271);
        return 0;
      }
      AppMethodBeat.o(63271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zf
 * JD-Core Version:    0.7.0.1
 */