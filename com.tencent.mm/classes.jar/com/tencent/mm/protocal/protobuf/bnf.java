package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bnf
  extends com.tencent.mm.cd.a
{
  public String CMP;
  public String CMQ;
  public String CNj;
  public int RXp;
  public bno SYl;
  public String SYm;
  public String Sqe;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42632);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.CMP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Name");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.Sqe == null)
      {
        paramVarArgs = new b("Not all required fields were included: Remark");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.CNj == null)
      {
        paramVarArgs = new b("Not all required fields were included: IconUrl");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.SYl == null)
      {
        paramVarArgs = new b("Not all required fields were included: DownloadInfo");
        AppMethodBeat.o(42632);
        throw paramVarArgs;
      }
      if (this.lVG != null) {
        paramVarArgs.f(1, this.lVG);
      }
      if (this.CMP != null) {
        paramVarArgs.f(2, this.CMP);
      }
      if (this.Sqe != null) {
        paramVarArgs.f(3, this.Sqe);
      }
      if (this.CNj != null) {
        paramVarArgs.f(4, this.CNj);
      }
      if (this.CMQ != null) {
        paramVarArgs.f(5, this.CMQ);
      }
      if (this.SYl != null)
      {
        paramVarArgs.oE(6, this.SYl.computeSize());
        this.SYl.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(7, this.RXp);
      if (this.SYm != null) {
        paramVarArgs.f(8, this.SYm);
      }
      AppMethodBeat.o(42632);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lVG == null) {
        break label940;
      }
    }
    label940:
    for (int i = g.a.a.b.b.a.g(1, this.lVG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMP);
      }
      i = paramInt;
      if (this.Sqe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sqe);
      }
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CNj);
      }
      i = paramInt;
      if (this.CMQ != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CMQ);
      }
      paramInt = i;
      if (this.SYl != null) {
        paramInt = i + g.a.a.a.oD(6, this.SYl.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.RXp);
      paramInt = i;
      if (this.SYm != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.SYm);
      }
      AppMethodBeat.o(42632);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.lVG == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.CMP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Name");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.Sqe == null)
        {
          paramVarArgs = new b("Not all required fields were included: Remark");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.CNj == null)
        {
          paramVarArgs = new b("Not all required fields were included: IconUrl");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        if (this.SYl == null)
        {
          paramVarArgs = new b("Not all required fields were included: DownloadInfo");
          AppMethodBeat.o(42632);
          throw paramVarArgs;
        }
        AppMethodBeat.o(42632);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bnf localbnf = (bnf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42632);
          return -1;
        case 1: 
          localbnf.lVG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 2: 
          localbnf.CMP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 3: 
          localbnf.Sqe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 4: 
          localbnf.CNj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 5: 
          localbnf.CMQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(42632);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bno localbno = new bno();
            if ((localObject != null) && (localObject.length > 0)) {
              localbno.parseFrom((byte[])localObject);
            }
            localbnf.SYl = localbno;
            paramInt += 1;
          }
          AppMethodBeat.o(42632);
          return 0;
        case 7: 
          localbnf.RXp = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(42632);
          return 0;
        }
        localbnf.SYm = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(42632);
        return 0;
      }
      AppMethodBeat.o(42632);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnf
 * JD-Core Version:    0.7.0.1
 */