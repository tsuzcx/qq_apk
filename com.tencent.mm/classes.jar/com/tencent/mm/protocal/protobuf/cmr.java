package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class cmr
  extends dyl
{
  public String Tug;
  public String Tuh;
  public String Tui;
  public b Tuj;
  public int Tuk;
  public String Tul;
  public int Tum;
  public String fdH;
  public String jUi;
  public String scope;
  public String signature;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82433);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.jUi != null) {
        paramVarArgs.f(3, this.jUi);
      }
      if (this.Tug != null) {
        paramVarArgs.f(4, this.Tug);
      }
      if (this.fdH != null) {
        paramVarArgs.f(5, this.fdH);
      }
      if (this.Tuh != null) {
        paramVarArgs.f(6, this.Tuh);
      }
      if (this.signature != null) {
        paramVarArgs.f(7, this.signature);
      }
      if (this.Tui != null) {
        paramVarArgs.f(8, this.Tui);
      }
      if (this.Tuj != null) {
        paramVarArgs.c(9, this.Tuj);
      }
      paramVarArgs.aY(10, this.Tuk);
      if (this.scope != null) {
        paramVarArgs.f(11, this.scope);
      }
      if (this.Tul != null) {
        paramVarArgs.f(12, this.Tul);
      }
      paramVarArgs.aY(13, this.Tum);
      AppMethodBeat.o(82433);
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
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.jUi != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jUi);
      }
      paramInt = i;
      if (this.Tug != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tug);
      }
      i = paramInt;
      if (this.fdH != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fdH);
      }
      paramInt = i;
      if (this.Tuh != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tuh);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.signature);
      }
      paramInt = i;
      if (this.Tui != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Tui);
      }
      i = paramInt;
      if (this.Tuj != null) {
        i = paramInt + g.a.a.b.b.a.b(9, this.Tuj);
      }
      i += g.a.a.b.b.a.bM(10, this.Tuk);
      paramInt = i;
      if (this.scope != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.scope);
      }
      i = paramInt;
      if (this.Tul != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.Tul);
      }
      paramInt = g.a.a.b.b.a.bM(13, this.Tum);
      AppMethodBeat.o(82433);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(82433);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cmr localcmr = (cmr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82433);
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
            localcmr.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(82433);
          return 0;
        case 2: 
          localcmr.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 3: 
          localcmr.jUi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 4: 
          localcmr.Tug = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 5: 
          localcmr.fdH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 6: 
          localcmr.Tuh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 7: 
          localcmr.signature = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 8: 
          localcmr.Tui = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 9: 
          localcmr.Tuj = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(82433);
          return 0;
        case 10: 
          localcmr.Tuk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(82433);
          return 0;
        case 11: 
          localcmr.scope = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82433);
          return 0;
        case 12: 
          localcmr.Tul = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82433);
          return 0;
        }
        localcmr.Tum = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(82433);
        return 0;
      }
      AppMethodBeat.o(82433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmr
 * JD-Core Version:    0.7.0.1
 */