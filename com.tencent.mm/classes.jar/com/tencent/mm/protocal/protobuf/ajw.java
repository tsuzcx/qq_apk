package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ajw
  extends com.tencent.mm.cd.a
{
  public String CMB;
  public String CNj;
  public String ProductID;
  public int Suo;
  public ajv Tel;
  public String Ten;
  public String Teq;
  public String Ter;
  public int ffF;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104770);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tel == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerImg");
        AppMethodBeat.o(104770);
        throw paramVarArgs;
      }
      if (this.Tel != null)
      {
        paramVarArgs.oE(1, this.Tel.computeSize());
        this.Tel.writeFields(paramVarArgs);
      }
      if (this.fwr != null) {
        paramVarArgs.f(2, this.fwr);
      }
      if (this.Ten != null) {
        paramVarArgs.f(3, this.Ten);
      }
      paramVarArgs.aY(4, this.ffF);
      if (this.Teq != null) {
        paramVarArgs.f(5, this.Teq);
      }
      paramVarArgs.aY(6, this.Suo);
      if (this.CNj != null) {
        paramVarArgs.f(7, this.CNj);
      }
      if (this.CMB != null) {
        paramVarArgs.f(8, this.CMB);
      }
      if (this.ProductID != null) {
        paramVarArgs.f(9, this.ProductID);
      }
      if (this.Ter != null) {
        paramVarArgs.f(10, this.Ter);
      }
      AppMethodBeat.o(104770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tel == null) {
        break label856;
      }
    }
    label856:
    for (int i = g.a.a.a.oD(1, this.Tel.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fwr);
      }
      i = paramInt;
      if (this.Ten != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ten);
      }
      i += g.a.a.b.b.a.bM(4, this.ffF);
      paramInt = i;
      if (this.Teq != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Teq);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.Suo);
      paramInt = i;
      if (this.CNj != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.CNj);
      }
      i = paramInt;
      if (this.CMB != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.CMB);
      }
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.ProductID);
      }
      i = paramInt;
      if (this.Ter != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.Ter);
      }
      AppMethodBeat.o(104770);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Tel == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerImg");
          AppMethodBeat.o(104770);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104770);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ajw localajw = (ajw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104770);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ajv localajv = new ajv();
            if ((localObject != null) && (localObject.length > 0)) {
              localajv.parseFrom((byte[])localObject);
            }
            localajw.Tel = localajv;
            paramInt += 1;
          }
          AppMethodBeat.o(104770);
          return 0;
        case 2: 
          localajw.fwr = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 3: 
          localajw.Ten = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 4: 
          localajw.ffF = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104770);
          return 0;
        case 5: 
          localajw.Teq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 6: 
          localajw.Suo = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(104770);
          return 0;
        case 7: 
          localajw.CNj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 8: 
          localajw.CMB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 9: 
          localajw.ProductID = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(104770);
          return 0;
        }
        localajw.Ter = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(104770);
        return 0;
      }
      AppMethodBeat.o(104770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajw
 * JD-Core Version:    0.7.0.1
 */